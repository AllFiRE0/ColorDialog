package com.customui;

import com.customui.commands.CustomUICommand;
import com.customui.config.ConfigManager;
import com.customui.menu.MenuManager;
import org.bukkit.plugin.java.JavaPlugin;

public class CustomUIPlugin extends JavaPlugin {
    
    private ConfigManager configManager;
    private MenuManager menuManager;
    
    @Override
    public void onEnable() {
        // Инициализация конфигурации
        configManager = new ConfigManager(this);
        configManager.loadConfig();
        
        // Инициализация менеджера меню
        menuManager = new MenuManager(this, configManager);
        
        // Регистрация команд
        getCommand("customui").setExecutor(new CustomUICommand(this, menuManager));
        
        getLogger().info("CustomUI plugin enabled successfully!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("CustomUI plugin disabled!");
    }
    
    public ConfigManager getConfigManager() {
        return configManager;
    }
    
    public MenuManager getMenuManager() {
        return menuManager;
    }
}