package com.customui;

import com.customui.commands.CustomUICommand;
import com.customui.config.ConfigManager;
import com.customui.integrations.LuckPermsIntegration;
import com.customui.menu.MenuManager;
import com.customui.placeholders.CustomUIPlaceholders;
import com.customui.utils.PlaceholderUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomUIPlugin extends JavaPlugin {
    
    private ConfigManager configManager;
    private MenuManager menuManager;
    private LuckPermsIntegration luckPermsIntegration;
    private CustomUIPlaceholders placeholderExpansion;
    private PlaceholderUtils placeholderUtils;
    
    @Override
    public void onEnable() {
        // Инициализация конфигурации
        configManager = new ConfigManager(this);
        configManager.loadConfig();
        
        // Инициализация утилит
        placeholderUtils = new PlaceholderUtils(this);
        
        // Инициализация интеграций
        initializeIntegrations();
        
        // Инициализация менеджера меню
        menuManager = new MenuManager(this, configManager);
        
        // Регистрация команд
        getCommand("customui").setExecutor(new CustomUICommand(this, menuManager));
        
        getLogger().info("CustomUI plugin enabled successfully!");
        logIntegrations();
    }
    
    @Override
    public void onDisable() {
        // Отключение PlaceholderAPI расширения
        if (placeholderExpansion != null) {
            placeholderExpansion.unregister();
        }
        
        getLogger().info("CustomUI plugin disabled!");
    }
    
    private void initializeIntegrations() {
        // Инициализация LuckPerms
        luckPermsIntegration = new LuckPermsIntegration(this);
        
        // Инициализация PlaceholderAPI
        if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
            placeholderExpansion = new CustomUIPlaceholders(this);
            if (placeholderExpansion.register()) {
                getLogger().info("PlaceholderAPI расширение зарегистрировано!");
            } else {
                getLogger().warning("Не удалось зарегистрировать PlaceholderAPI расширение!");
            }
        } else {
            getLogger().warning("PlaceholderAPI не найден! Плейсхолдеры будут недоступны.");
        }
    }
    
    private void logIntegrations() {
        getLogger().info("=== Интеграции ===");
        getLogger().info("LuckPerms: " + (luckPermsIntegration.isEnabled() ? "✓" : "✗"));
        getLogger().info("PlaceholderAPI: " + (placeholderExpansion != null ? "✓" : "✗"));
        getLogger().info("==================");
    }
    
    public String parsePlaceholders(org.bukkit.entity.Player player, String text) {
        if (placeholderExpansion != null && text != null) {
            return PlaceholderAPI.setPlaceholders(player, text);
        }
        return text;
    }
    
    public ConfigManager getConfigManager() {
        return configManager;
    }
    
    public MenuManager getMenuManager() {
        return menuManager;
    }
    
    public LuckPermsIntegration getLuckPermsIntegration() {
        return luckPermsIntegration;
    }
    
    public CustomUIPlaceholders getPlaceholderExpansion() {
        return placeholderExpansion;
    }
}