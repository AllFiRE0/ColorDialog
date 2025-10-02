package com.customui.placeholders;

import com.customui.CustomUIPlugin;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomUIPlaceholders extends PlaceholderExpansion {
    
    private final CustomUIPlugin plugin;
    private LuckPerms luckPerms;
    
    public CustomUIPlaceholders(CustomUIPlugin plugin) {
        this.plugin = plugin;
        try {
            this.luckPerms = LuckPermsProvider.get();
        } catch (IllegalStateException e) {
            plugin.getLogger().warning("LuckPerms не найден! Некоторые плейсхолдеры будут недоступны.");
        }
    }
    
    @Override
    public @NotNull String getIdentifier() {
        return "customui";
    }
    
    @Override
    public @NotNull String getAuthor() {
        return plugin.getDescription().getAuthors().toString();
    }
    
    @Override
    public @NotNull String getVersion() {
        return plugin.getDescription().getVersion();
    }
    
    @Override
    public boolean persist() {
        return true;
    }
    
    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) {
            return "";
        }
        
        // Основные плейсхолдеры игрока
        switch (params.toLowerCase()) {
            case "player_name":
                return player.getName();
            case "player_displayname":
                return player.getDisplayName();
            case "player_uuid":
                return player.getUniqueId().toString();
            case "player_world":
                return player.getWorld().getName();
            case "player_health":
                return String.valueOf(Math.round(player.getHealth()));
            case "player_max_health":
                return String.valueOf(Math.round(player.getMaxHealth()));
            case "player_food":
                return String.valueOf(player.getFoodLevel());
            case "player_level":
                return String.valueOf(player.getLevel());
            case "player_exp":
                return String.valueOf(player.getTotalExperience());
            case "player_gamemode":
                return player.getGameMode().name();
            case "player_ping":
                return String.valueOf(player.getPing());
            case "player_view_distance":
                return String.valueOf(player.getClientViewDistance());
        }
        
        // LuckPerms плейсхолдеры
        if (luckPerms != null) {
            User user = luckPerms.getUserManager().getUser(player.getUniqueId());
            if (user != null) {
                CachedMetaData metaData = user.getCachedData().getMetaData();
                
                switch (params.toLowerCase()) {
                    case "luckperms_prefix":
                        return metaData.getPrefix() != null ? metaData.getPrefix() : "";
                    case "luckperms_suffix":
                        return metaData.getSuffix() != null ? metaData.getSuffix() : "";
                    case "luckperms_primary_group":
                        return user.getPrimaryGroup();
                    case "luckperms_groups":
                        return String.join(", ", user.getGroups().stream()
                                .map(group -> group.getName())
                                .toArray(String[]::new));
                    case "luckperms_weight":
                        return String.valueOf(user.getPrimaryGroup().equals("default") ? 0 : 
                                luckPerms.getGroupManager().getGroup(user.getPrimaryGroup()).getWeight().orElse(0));
                    case "luckperms_meta_prefix":
                        return metaData.getMetaValue("prefix") != null ? metaData.getMetaValue("prefix") : "";
                    case "luckperms_meta_suffix":
                        return metaData.getMetaValue("suffix") != null ? metaData.getMetaValue("suffix") : "";
                }
            }
        }
        
        // Плейсхолдеры сервера
        switch (params.toLowerCase()) {
            case "server_name":
                return plugin.getServer().getName();
            case "server_version":
                return plugin.getServer().getVersion();
            case "server_motd":
                return plugin.getServer().getMotd();
            case "server_online":
                return String.valueOf(plugin.getServer().getOnlinePlayers().size());
            case "server_max_players":
                return String.valueOf(plugin.getServer().getMaxPlayers());
            case "server_tps":
                return String.valueOf(Math.round(plugin.getServer().getTps()[0] * 100.0) / 100.0);
            case "server_uptime":
                long uptime = System.currentTimeMillis() - plugin.getServer().getServerTickManager().getServerTickTime();
                return formatUptime(uptime);
        }
        
        // Плейсхолдеры времени
        switch (params.toLowerCase()) {
            case "time_current":
                return java.time.LocalTime.now().toString();
            case "time_date":
                return java.time.LocalDate.now().toString();
            case "time_datetime":
                return java.time.LocalDateTime.now().toString();
            case "time_timestamp":
                return String.valueOf(System.currentTimeMillis());
        }
        
        // Плейсхолдеры для меню
        switch (params.toLowerCase()) {
            case "menu_tab_enabled":
                return plugin.getMenuManager().hasMenu("tab") ? "true" : "false";
            case "menu_chat_enabled":
                return plugin.getMenuManager().hasMenu("chat") ? "true" : "false";
            case "menu_scoreboard_enabled":
                return plugin.getMenuManager().hasMenu("scoreboard") ? "true" : "false";
            case "menu_displayname_enabled":
                return plugin.getMenuManager().hasMenu("displayname") ? "true" : "false";
            case "menu_title_enabled":
                return plugin.getMenuManager().hasMenu("title") ? "true" : "false";
            case "menu_viewdistance_enabled":
                return plugin.getMenuManager().hasMenu("viewdistance") ? "true" : "false";
        }
        
        return null;
    }
    
    private String formatUptime(long milliseconds) {
        long seconds = milliseconds / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        
        if (days > 0) {
            return days + "д " + (hours % 24) + "ч " + (minutes % 60) + "м";
        } else if (hours > 0) {
            return hours + "ч " + (minutes % 60) + "м " + (seconds % 60) + "с";
        } else if (minutes > 0) {
            return minutes + "м " + (seconds % 60) + "с";
        } else {
            return seconds + "с";
        }
    }
}