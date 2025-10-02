package com.customui.menu.dialogs;

import com.customui.CustomUIPlugin;
import com.customui.config.ConfigManager;
import com.customui.menu.BaseMenuDialog;
import io.papermc.paper.dialog.DialogBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ViewDistanceMenuDialog extends BaseMenuDialog {
    
    private int currentViewDistance = 12; // Значение по умолчанию
    
    public ViewDistanceMenuDialog(CustomUIPlugin plugin, ConfigManager configManager) {
        super(plugin, configManager, "viewdistance");
    }
    
    public ViewDistanceMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, FileConfiguration config) {
        super(plugin, configManager, "viewdistance", config);
        this.currentViewDistance = config.getInt("options.default_distance", 12);
    }
    
    @Override
    protected void addButtons(DialogBuilder builder, Player player) {
        // Слайдер для настройки дистанции видимости (8-24)
        for (int distance = 8; distance <= 24; distance++) {
            final int finalDistance = distance;
            NamedTextColor color = getDistanceColor(distance);
            String emoji = getDistanceEmoji(distance);
            
            builder.button(createButton(emoji + " " + distance + " чанков", color), 
                    (clicker, result) -> {
                        setViewDistance(player, finalDistance);
                        currentViewDistance = finalDistance;
                        sendMessage(player, "Дистанция видимости установлена: " + finalDistance + " чанков");
                        return Dialog.ActionResult.close();
                    });
        }
        
        // Кнопки для быстрого выбора популярных значений
        builder.button(createButton("⚡ Быстро (8 чанков)", NamedTextColor.RED), 
                (clicker, result) -> {
                    setViewDistance(player, 8);
                    currentViewDistance = 8;
                    sendMessage(player, "Дистанция видимости установлена: 8 чанков (быстро)");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🏃 Обычно (12 чанков)", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setViewDistance(player, 12);
                    currentViewDistance = 12;
                    sendMessage(player, "Дистанция видимости установлена: 12 чанков (обычно)");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🚶 Медленно (16 чанков)", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setViewDistance(player, 16);
                    currentViewDistance = 16;
                    sendMessage(player, "Дистанция видимости установлена: 16 чанков (медленно)");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🐌 Очень медленно (20 чанков)", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setViewDistance(player, 20);
                    currentViewDistance = 20;
                    sendMessage(player, "Дистанция видимости установлена: 20 чанков (очень медленно)");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🦥 Максимум (24 чанка)", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setViewDistance(player, 24);
                    currentViewDistance = 24;
                    sendMessage(player, "Дистанция видимости установлена: 24 чанка (максимум)");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки управления
        builder.button(createButton("✅ Применить", NamedTextColor.GREEN, TextDecoration.BOLD), 
                (clicker, result) -> {
                    applyViewDistanceSettings(player);
                    sendMessage(player, "Настройки дистанции видимости применены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔁 Сбросить", NamedTextColor.YELLOW, TextDecoration.BOLD), 
                (clicker, result) -> {
                    resetViewDistanceSettings(player);
                    sendMessage(player, "Настройки дистанции видимости сброшены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("❌ Отмена", NamedTextColor.RED, TextDecoration.BOLD), 
                (clicker, result) -> {
                    sendMessage(player, "Настройки отменены!");
                    return Dialog.ActionResult.close();
                });
    }
    
    private NamedTextColor getDistanceColor(int distance) {
        if (distance <= 10) return NamedTextColor.RED;
        if (distance <= 14) return NamedTextColor.YELLOW;
        if (distance <= 18) return NamedTextColor.GREEN;
        if (distance <= 22) return NamedTextColor.BLUE;
        return NamedTextColor.LIGHT_PURPLE;
    }
    
    private String getDistanceEmoji(int distance) {
        if (distance <= 8) return "⚡";
        if (distance <= 12) return "🏃";
        if (distance <= 16) return "🚶";
        if (distance <= 20) return "🐌";
        return "🦥";
    }
    
    private void setViewDistance(Player player, int distance) {
        String action = getString("actions.set_distance", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%distance%", String.valueOf(distance)));
        }
    }
    
    private void applyViewDistanceSettings(Player player) {
        String action = getString("actions.apply", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
    
    private void resetViewDistanceSettings(Player player) {
        String action = getString("actions.reset", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
}