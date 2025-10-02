package com.customui.menu;

import com.customui.CustomUIPlugin;
import com.customui.config.ConfigManager;
import com.customui.menu.dialogs.TabMenuDialog;
import com.customui.menu.dialogs.ChatMenuDialog;
import com.customui.menu.dialogs.ScoreboardMenuDialog;
import com.customui.menu.dialogs.DisplayNameMenuDialog;
import com.customui.menu.dialogs.TitleMenuDialog;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class MenuManager {
    
    private final CustomUIPlugin plugin;
    private final ConfigManager configManager;
    private final Map<String, BaseMenuDialog> menuDialogs;
    
    public MenuManager(CustomUIPlugin plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.menuDialogs = new HashMap<>();
        
        initializeMenus();
    }
    
    private void initializeMenus() {
        // Инициализация стандартных меню
        menuDialogs.put("tab", new TabMenuDialog(plugin, configManager));
        menuDialogs.put("chat", new ChatMenuDialog(plugin, configManager));
        menuDialogs.put("scoreboard", new ScoreboardMenuDialog(plugin, configManager));
        menuDialogs.put("displayname", new DisplayNameMenuDialog(plugin, configManager));
        menuDialogs.put("title", new TitleMenuDialog(plugin, configManager));
        
        // Загрузка пользовательских меню из конфигурации
        loadCustomMenus();
    }
    
    private void loadCustomMenus() {
        Map<String, FileConfiguration> menuConfigs = configManager.getAllMenuConfigs();
        
        for (Map.Entry<String, FileConfiguration> entry : menuConfigs.entrySet()) {
            String menuName = entry.getKey();
            FileConfiguration config = entry.getValue();
            
            // Пропускаем стандартные меню
            if (menuDialogs.containsKey(menuName)) {
                continue;
            }
            
            String type = config.getString("type", "custom");
            BaseMenuDialog dialog = createCustomMenuDialog(menuName, type, config);
            if (dialog != null) {
                menuDialogs.put(menuName, dialog);
            }
        }
    }
    
    private BaseMenuDialog createCustomMenuDialog(String menuName, String type, FileConfiguration config) {
        switch (type.toLowerCase()) {
            case "tab":
                return new TabMenuDialog(plugin, configManager, config);
            case "chat":
                return new ChatMenuDialog(plugin, configManager, config);
            case "scoreboard":
                return new ScoreboardMenuDialog(plugin, configManager, config);
            case "displayname":
                return new DisplayNameMenuDialog(plugin, configManager, config);
            case "title":
                return new TitleMenuDialog(plugin, configManager, config);
            default:
                return new CustomMenuDialog(plugin, configManager, menuName, config);
        }
    }
    
    public void openMenu(Player player, String menuName) {
        BaseMenuDialog dialog = menuDialogs.get(menuName);
        if (dialog != null) {
            dialog.open(player);
        } else {
            player.sendMessage("§cМеню '" + menuName + "' не найдено!");
        }
    }
    
    public boolean hasMenu(String menuName) {
        return menuDialogs.containsKey(menuName);
    }
    
    public Map<String, BaseMenuDialog> getAvailableMenus() {
        return new HashMap<>(menuDialogs);
    }
    
    public void reloadMenus() {
        menuDialogs.clear();
        initializeMenus();
    }
}