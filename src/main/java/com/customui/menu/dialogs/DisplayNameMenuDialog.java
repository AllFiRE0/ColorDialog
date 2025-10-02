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

public class DisplayNameMenuDialog extends BaseMenuDialog {
    
    public DisplayNameMenuDialog(CustomUIPlugin plugin, ConfigManager configManager) {
        super(plugin, configManager, "displayname");
    }
    
    public DisplayNameMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, FileConfiguration config) {
        super(plugin, configManager, "displayname", config);
    }
    
    @Override
    protected void addButtons(DialogBuilder builder, Player player) {
        // Кнопки для настройки префикса ника
        builder.button(createButton("🟥 Красный Префикс", NamedTextColor.RED), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&c[VIP]");
                    sendMessage(player, "Префикс ника установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Префикс", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&9[VIP]");
                    sendMessage(player, "Префикс ника установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Префикс", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&e[VIP]");
                    sendMessage(player, "Префикс ника установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Префикс", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&6[VIP]");
                    sendMessage(player, "Префикс ника установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Префикс", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&a[VIP]");
                    sendMessage(player, "Префикс ника установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Префикс", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&d[VIP]");
                    sendMessage(player, "Префикс ника установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Префикс", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&4[VIP]");
                    sendMessage(player, "Префикс ника установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Префикс", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setDisplayNamePrefix(player, "&0[VIP]");
                    sendMessage(player, "Префикс ника установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки суффикса ника
        builder.button(createButton("🟥 Красный Суффикс", NamedTextColor.RED), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&c[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Суффикс", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&9[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Суффикс", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&e[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Суффикс", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&6[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Суффикс", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&a[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Суффикс", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&d[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Суффикс", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&4[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Суффикс", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setDisplayNameSuffix(player, "&0[Level %level%]");
                    sendMessage(player, "Суффикс ника установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки цвета ника
        builder.button(createButton("🟥 Красный Ник", NamedTextColor.RED), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&c");
                    sendMessage(player, "Цвет ника установлен на красный!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Ник", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&9");
                    sendMessage(player, "Цвет ника установлен на синий!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Ник", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&e");
                    sendMessage(player, "Цвет ника установлен на желтый!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Ник", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&6");
                    sendMessage(player, "Цвет ника установлен на оранжевый!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Ник", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&a");
                    sendMessage(player, "Цвет ника установлен на зеленый!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Ник", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&d");
                    sendMessage(player, "Цвет ника установлен на фиолетовый!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Ник", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&4");
                    sendMessage(player, "Цвет ника установлен на коричневый!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Ник", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setDisplayNameColor(player, "&0");
                    sendMessage(player, "Цвет ника установлен на черный!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки управления
        builder.button(createButton("✅ Применить", NamedTextColor.GREEN, TextDecoration.BOLD), 
                (clicker, result) -> {
                    applyDisplayNameSettings(player);
                    sendMessage(player, "Настройки ника применены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔁 Сбросить", NamedTextColor.YELLOW, TextDecoration.BOLD), 
                (clicker, result) -> {
                    resetDisplayNameSettings(player);
                    sendMessage(player, "Настройки ника сброшены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("❌ Отмена", NamedTextColor.RED, TextDecoration.BOLD), 
                (clicker, result) -> {
                    sendMessage(player, "Настройки отменены!");
                    return Dialog.ActionResult.close();
                });
    }
    
    private void setDisplayNamePrefix(Player player, String prefix) {
        String action = getString("actions.prefix", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%prefix%", prefix));
        }
    }
    
    private void setDisplayNameSuffix(Player player, String suffix) {
        String action = getString("actions.suffix", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%suffix%", suffix));
        }
    }
    
    private void setDisplayNameColor(Player player, String color) {
        String action = getString("actions.color", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%color%", color));
        }
    }
    
    private void applyDisplayNameSettings(Player player) {
        String action = getString("actions.apply", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
    
    private void resetDisplayNameSettings(Player player) {
        String action = getString("actions.reset", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
}