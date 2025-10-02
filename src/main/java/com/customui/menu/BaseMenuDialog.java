package com.customui.menu;

import com.customui.CustomUIPlugin;
import com.customui.config.ConfigManager;
import io.papermc.paper.dialog.Dialog;
import io.papermc.paper.dialog.DialogBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMenuDialog {
    
    protected final CustomUIPlugin plugin;
    protected final ConfigManager configManager;
    protected final String menuName;
    protected final FileConfiguration config;
    
    public BaseMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, String menuName) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.menuName = menuName;
        this.config = configManager.getMenuConfig(menuName);
    }
    
    public BaseMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, String menuName, FileConfiguration config) {
        this.plugin = plugin;
        this.configManager = configManager;
        this.menuName = menuName;
        this.config = config;
    }
    
    public void open(Player player) {
        DialogBuilder builder = Dialog.builder()
                .title(getTitle())
                .description(getDescription());
        
        addButtons(builder, player);
        
        Dialog dialog = builder.build();
        dialog.open(player);
    }
    
    protected Component getTitle() {
        String title = config.getString("title", "Настройки");
        return Component.text(title)
                .color(NamedTextColor.GOLD)
                .decorate(TextDecoration.BOLD);
    }
    
    protected Component getDescription() {
        String description = config.getString("description", "Выберите настройки");
        return Component.text(description)
                .color(NamedTextColor.GRAY);
    }
    
    protected abstract void addButtons(DialogBuilder builder, Player player);
    
    protected Component createButton(String text, NamedTextColor color) {
        return Component.text(text)
                .color(color)
                .decorate(TextDecoration.BOLD);
    }
    
    protected Component createButton(String text, NamedTextColor color, TextDecoration decoration) {
        return Component.text(text)
                .color(color)
                .decorate(decoration);
    }
    
    protected List<String> getStringList(String path) {
        List<String> list = config.getStringList(path);
        return list != null ? list : new ArrayList<>();
    }
    
    protected String getString(String path, String defaultValue) {
        return config.getString(path, defaultValue);
    }
    
    protected void executeAction(Player player, String action) {
        if (action == null || action.isEmpty()) {
            return;
        }
        
        // Парсинг плейсхолдеров в действии
        String parsedAction = plugin.parsePlaceholders(player, action);
        
        // Выполнение команды от имени игрока
        if (parsedAction.startsWith("/")) {
            player.performCommand(parsedAction.substring(1));
        } else {
            // Выполнение команды от имени консоли
            plugin.getServer().dispatchCommand(plugin.getServer().getConsoleSender(), parsedAction);
        }
    }
    
    protected void sendMessage(Player player, String message) {
        player.sendMessage(Component.text(message)
                .color(NamedTextColor.YELLOW));
    }
}