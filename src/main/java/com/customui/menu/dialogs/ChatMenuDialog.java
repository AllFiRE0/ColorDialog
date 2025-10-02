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

public class ChatMenuDialog extends BaseMenuDialog {
    
    public ChatMenuDialog(CustomUIPlugin plugin, ConfigManager configManager) {
        super(plugin, configManager, "chat");
    }
    
    public ChatMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, FileConfiguration config) {
        super(plugin, configManager, "chat", config);
    }
    
    @Override
    protected void addButtons(DialogBuilder builder, Player player) {
        // Кнопки для настройки формата чата
        builder.button(createButton("🟥 Красный Формат", NamedTextColor.RED), 
                (clicker, result) -> {
                    setChatFormat(player, "&c[&6%level%&c] &f%player%&c: &f%message%");
                    sendMessage(player, "Формат чата установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Формат", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setChatFormat(player, "&9[&6%level%&9] &f%player%&9: &f%message%");
                    sendMessage(player, "Формат чата установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Формат", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setChatFormat(player, "&e[&6%level%&e] &f%player%&e: &f%message%");
                    sendMessage(player, "Формат чата установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Формат", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setChatFormat(player, "&6[&6%level%&6] &f%player%&6: &f%message%");
                    sendMessage(player, "Формат чата установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Формат", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setChatFormat(player, "&a[&6%level%&a] &f%player%&a: &f%message%");
                    sendMessage(player, "Формат чата установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Формат", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setChatFormat(player, "&d[&6%level%&d] &f%player%&d: &f%message%");
                    sendMessage(player, "Формат чата установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Формат", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setChatFormat(player, "&4[&6%level%&4] &f%player%&4: &f%message%");
                    sendMessage(player, "Формат чата установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Формат", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setChatFormat(player, "&0[&6%level%&0] &f%player%&0: &f%message%");
                    sendMessage(player, "Формат чата установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки префикса
        builder.button(createButton("🟥 Красный Префикс", NamedTextColor.RED), 
                (clicker, result) -> {
                    setChatPrefix(player, "&c[VIP]");
                    sendMessage(player, "Префикс установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Префикс", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setChatPrefix(player, "&9[VIP]");
                    sendMessage(player, "Префикс установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Префикс", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setChatPrefix(player, "&e[VIP]");
                    sendMessage(player, "Префикс установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Префикс", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setChatPrefix(player, "&6[VIP]");
                    sendMessage(player, "Префикс установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Префикс", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setChatPrefix(player, "&a[VIP]");
                    sendMessage(player, "Префикс установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Префикс", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setChatPrefix(player, "&d[VIP]");
                    sendMessage(player, "Префикс установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Префикс", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setChatPrefix(player, "&4[VIP]");
                    sendMessage(player, "Префикс установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Префикс", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setChatPrefix(player, "&0[VIP]");
                    sendMessage(player, "Префикс установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки управления
        builder.button(createButton("✅ Применить", NamedTextColor.GREEN, TextDecoration.BOLD), 
                (clicker, result) -> {
                    applyChatSettings(player);
                    sendMessage(player, "Настройки чата применены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔁 Сбросить", NamedTextColor.YELLOW, TextDecoration.BOLD), 
                (clicker, result) -> {
                    resetChatSettings(player);
                    sendMessage(player, "Настройки чата сброшены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("❌ Отмена", NamedTextColor.RED, TextDecoration.BOLD), 
                (clicker, result) -> {
                    sendMessage(player, "Настройки отменены!");
                    return Dialog.ActionResult.close();
                });
    }
    
    private void setChatFormat(Player player, String format) {
        String action = getString("actions.format", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%format%", format));
        }
    }
    
    private void setChatPrefix(Player player, String prefix) {
        String action = getString("actions.prefix", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%prefix%", prefix));
        }
    }
    
    private void applyChatSettings(Player player) {
        String action = getString("actions.apply", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
    
    private void resetChatSettings(Player player) {
        String action = getString("actions.reset", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
}