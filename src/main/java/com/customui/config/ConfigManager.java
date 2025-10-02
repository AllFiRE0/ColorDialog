package com.customui.config;

import com.customui.CustomUIPlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    
    private final CustomUIPlugin plugin;
    private FileConfiguration config;
    private Map<String, FileConfiguration> menuConfigs;
    
    public ConfigManager(CustomUIPlugin plugin) {
        this.plugin = plugin;
        this.menuConfigs = new HashMap<>();
    }
    
    public void loadConfig() {
        // Создание основной конфигурации
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
        
        // Создание папки для конфигураций меню
        File menusDir = new File(plugin.getDataFolder(), "menus");
        if (!menusDir.exists()) {
            menusDir.mkdirs();
        }
        
        // Загрузка конфигураций меню
        loadMenuConfigs();
    }
    
    private void loadMenuConfigs() {
        File menusDir = new File(plugin.getDataFolder(), "menus");
        File[] menuFiles = menusDir.listFiles((dir, name) -> name.endsWith(".yml"));
        
        if (menuFiles != null) {
            for (File menuFile : menuFiles) {
                String menuName = menuFile.getName().replace(".yml", "");
                FileConfiguration menuConfig = YamlConfiguration.loadConfiguration(menuFile);
                menuConfigs.put(menuName, menuConfig);
            }
        }
        
        // Создание примеров конфигураций если их нет
        createDefaultMenuConfigs();
    }
    
    private void createDefaultMenuConfigs() {
        createTabMenuConfig();
        createChatMenuConfig();
        createScoreboardMenuConfig();
        createDisplayNameMenuConfig();
        createTitleMenuConfig();
    }
    
    private void createTabMenuConfig() {
        File tabFile = new File(plugin.getDataFolder(), "menus/tab.yml");
        if (!tabFile.exists()) {
            try {
                tabFile.createNewFile();
                FileConfiguration tabConfig = YamlConfiguration.loadConfiguration(tabFile);
                
                tabConfig.set("title", "Настройка Таба");
                tabConfig.set("description", "Выберите стиль для вашего таба");
                tabConfig.set("type", "tab");
                
                tabConfig.set("options.header", "&6&lВаш Таб");
                tabConfig.set("options.footer", "&7Добро пожаловать на сервер!");
                
                tabConfig.set("actions.header", "tab_header");
                tabConfig.set("actions.footer", "tab_footer");
                
                tabConfig.save(tabFile);
                menuConfigs.put("tab", tabConfig);
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create tab menu config: " + e.getMessage());
            }
        }
    }
    
    private void createChatMenuConfig() {
        File chatFile = new File(plugin.getDataFolder(), "menus/chat.yml");
        if (!chatFile.exists()) {
            try {
                chatFile.createNewFile();
                FileConfiguration chatConfig = YamlConfiguration.loadConfiguration(chatFile);
                
                chatConfig.set("title", "Настройка Чата");
                chatConfig.set("description", "Выберите стиль для вашего чата");
                chatConfig.set("type", "chat");
                
                chatConfig.set("options.format", "&7[&6%level%&7] &f%player%&7: &f%message%");
                chatConfig.set("options.prefix", "&6[VIP]");
                
                chatConfig.set("actions.format", "chat_format");
                chatConfig.set("actions.prefix", "chat_prefix");
                
                chatConfig.save(chatFile);
                menuConfigs.put("chat", chatConfig);
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create chat menu config: " + e.getMessage());
            }
        }
    }
    
    private void createScoreboardMenuConfig() {
        File scoreboardFile = new File(plugin.getDataFolder(), "menus/scoreboard.yml");
        if (!scoreboardFile.exists()) {
            try {
                scoreboardFile.createNewFile();
                FileConfiguration scoreboardConfig = YamlConfiguration.loadConfiguration(scoreboardFile);
                
                scoreboardConfig.set("title", "Настройка Скорборда");
                scoreboardConfig.set("description", "Выберите стиль для вашего скорборда");
                scoreboardConfig.set("type", "scoreboard");
                
                scoreboardConfig.set("options.title", "&6&lВаш Сервер");
                scoreboardConfig.set("options.lines", new String[]{
                    "&7━━━━━━━━━━━━━━━━━━",
                    "&6Игрок: &f%player%",
                    "&6Уровень: &f%level%",
                    "&6Баланс: &f%balance%",
                    "&7━━━━━━━━━━━━━━━━━━"
                });
                
                scoreboardConfig.set("actions.title", "scoreboard_title");
                scoreboardConfig.set("actions.lines", "scoreboard_lines");
                
                scoreboardConfig.save(scoreboardFile);
                menuConfigs.put("scoreboard", scoreboardConfig);
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create scoreboard menu config: " + e.getMessage());
            }
        }
    }
    
    private void createDisplayNameMenuConfig() {
        File displayNameFile = new File(plugin.getDataFolder(), "menus/displayname.yml");
        if (!displayNameFile.exists()) {
            try {
                displayNameFile.createNewFile();
                FileConfiguration displayNameConfig = YamlConfiguration.loadConfiguration(displayNameFile);
                
                displayNameConfig.set("title", "Настройка Ника");
                displayNameConfig.set("description", "Выберите цвет для вашего ника");
                displayNameConfig.set("type", "displayname");
                
                displayNameConfig.set("options.prefix", "&6[VIP]");
                displayNameConfig.set("options.suffix", "&7[Level %level%]");
                displayNameConfig.set("options.color", "&f");
                
                displayNameConfig.set("actions.prefix", "displayname_prefix");
                displayNameConfig.set("actions.suffix", "displayname_suffix");
                displayNameConfig.set("actions.color", "displayname_color");
                
                displayNameConfig.save(displayNameFile);
                menuConfigs.put("displayname", displayNameConfig);
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create displayname menu config: " + e.getMessage());
            }
        }
    }
    
    private void createTitleMenuConfig() {
        File titleFile = new File(plugin.getDataFolder(), "menus/title.yml");
        if (!titleFile.exists()) {
            try {
                titleFile.createNewFile();
                FileConfiguration titleConfig = YamlConfiguration.loadConfiguration(titleFile);
                
                titleConfig.set("title", "Настройка Титулов");
                titleConfig.set("description", "Выберите стиль для ваших титулов");
                titleConfig.set("type", "title");
                
                titleConfig.set("options.header", "&6&lДобро пожаловать!");
                titleConfig.set("options.subtitle", "&7На сервер!");
                titleConfig.set("options.timing", "normal");
                titleConfig.set("options.effect", "fadein");
                
                titleConfig.set("actions.header", "title_header %header%");
                titleConfig.set("actions.subtitle", "title_subtitle %subtitle%");
                titleConfig.set("actions.timing", "title_timing %timing%");
                titleConfig.set("actions.effect", "title_effect %effect%");
                titleConfig.set("actions.apply", "title_apply");
                titleConfig.set("actions.reset", "title_reset");
                
                titleConfig.save(titleFile);
                menuConfigs.put("title", titleConfig);
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create title menu config: " + e.getMessage());
            }
        }
    }
    
    public FileConfiguration getConfig() {
        return config;
    }
    
    public FileConfiguration getMenuConfig(String menuName) {
        return menuConfigs.get(menuName);
    }
    
    public Map<String, FileConfiguration> getAllMenuConfigs() {
        return menuConfigs;
    }
    
    public void reloadConfigs() {
        plugin.reloadConfig();
        config = plugin.getConfig();
        menuConfigs.clear();
        loadMenuConfigs();
    }
}