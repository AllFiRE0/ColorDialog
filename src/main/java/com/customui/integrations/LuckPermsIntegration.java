package com.customui.integrations;

import com.customui.CustomUIPlugin;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;

import java.util.concurrent.CompletableFuture;

public class LuckPermsIntegration {
    
    private final CustomUIPlugin plugin;
    private LuckPerms luckPerms;
    private boolean enabled = false;
    
    public LuckPermsIntegration(CustomUIPlugin plugin) {
        this.plugin = plugin;
        initialize();
    }
    
    private void initialize() {
        try {
            this.luckPerms = LuckPermsProvider.get();
            this.enabled = true;
            plugin.getLogger().info("LuckPerms интеграция успешно загружена!");
        } catch (Exception e) {
            plugin.getLogger().warning("LuckPerms не найден! Интеграция отключена.");
            this.enabled = false;
        }
    }
    
    public boolean isEnabled() {
        return enabled && luckPerms != null;
    }
    
    public CompletableFuture<String> getPlayerPrefix(Player player) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture("");
        }
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    CachedMetaData metaData = user.getCachedData().getMetaData();
                    String prefix = metaData.getPrefix();
                    return prefix != null ? prefix : "";
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении префикса: " + e.getMessage());
            }
            return "";
        });
    }
    
    public CompletableFuture<String> getPlayerSuffix(Player player) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture("");
        }
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    CachedMetaData metaData = user.getCachedData().getMetaData();
                    String suffix = metaData.getSuffix();
                    return suffix != null ? suffix : "";
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении суффикса: " + e.getMessage());
            }
            return "";
        });
    }
    
    public CompletableFuture<String> getPlayerPrimaryGroup(Player player) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture("default");
        }
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    return user.getPrimaryGroup();
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении основной группы: " + e.getMessage());
            }
            return "default";
        });
    }
    
    public CompletableFuture<String[]> getPlayerGroups(Player player) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture(new String[]{"default"});
        }
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    return user.getGroups().stream()
                            .map(group -> group.getName())
                            .toArray(String[]::new);
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении групп: " + e.getMessage());
            }
            return new String[]{"default"};
        });
    }
    
    public CompletableFuture<Integer> getPlayerWeight(Player player) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture(0);
        }
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    // Получаем вес основной группы
                    var group = luckPerms.getGroupManager().getGroup(user.getPrimaryGroup());
                    if (group != null) {
                        return group.getWeight().orElse(0);
                    }
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении веса: " + e.getMessage());
            }
            return 0;
        });
    }
    
    public CompletableFuture<String> getPlayerMetaValue(Player player, String key) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture("");
        }
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    CachedMetaData metaData = user.getCachedData().getMetaData();
                    String value = metaData.getMetaValue(key);
                    return value != null ? value : "";
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении мета-значения: " + e.getMessage());
            }
            return "";
        });
    }
    
    public CompletableFuture<Boolean> hasPermission(Player player, String permission) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture(false);
        }
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при проверке прав: " + e.getMessage());
            }
            return false;
        });
    }
    
    public CompletableFuture<Void> setPlayerPrefix(Player player, String prefix) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture(null);
        }
        
        return CompletableFuture.runAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    user.data().add(net.luckperms.api.node.Node.builder("prefix.100").value(prefix).build());
                    luckPerms.getUserManager().saveUser(user);
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при установке префикса: " + e.getMessage());
            }
        });
    }
    
    public CompletableFuture<Void> setPlayerSuffix(Player player, String suffix) {
        if (!isEnabled()) {
            return CompletableFuture.completedFuture(null);
        }
        
        return CompletableFuture.runAsync(() -> {
            try {
                User user = luckPerms.getUserManager().getUser(player.getUniqueId());
                if (user != null) {
                    user.data().add(net.luckperms.api.node.Node.builder("suffix.100").value(suffix).build());
                    luckPerms.getUserManager().saveUser(user);
                }
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при установке суффикса: " + e.getMessage());
            }
        });
    }
}