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

public class TabMenuDialog extends BaseMenuDialog {
    
    public TabMenuDialog(CustomUIPlugin plugin, ConfigManager configManager) {
        super(plugin, configManager, "tab");
    }
    
    public TabMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, FileConfiguration config) {
        super(plugin, configManager, "tab", config);
    }
    
    @Override
    protected void addButtons(DialogBuilder builder, Player player) {
        // Кнопки для настройки header
        builder.button(createButton("🟥 Красный Header", NamedTextColor.RED), 
                (clicker, result) -> {
                    setTabHeader(player, "&c&lВаш Таб");
                    sendMessage(player, "Header установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Header", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setTabHeader(player, "&9&lВаш Таб");
                    sendMessage(player, "Header установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Header", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setTabHeader(player, "&e&lВаш Таб");
                    sendMessage(player, "Header установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Header", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setTabHeader(player, "&6&lВаш Таб");
                    sendMessage(player, "Header установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Header", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setTabHeader(player, "&a&lВаш Таб");
                    sendMessage(player, "Header установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Header", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setTabHeader(player, "&d&lВаш Таб");
                    sendMessage(player, "Header установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Header", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setTabHeader(player, "&4&lВаш Таб");
                    sendMessage(player, "Header установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Header", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setTabHeader(player, "&0&lВаш Таб");
                    sendMessage(player, "Header установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки footer
        builder.button(createButton("🟥 Красный Footer", NamedTextColor.RED), 
                (clicker, result) -> {
                    setTabFooter(player, "&cДобро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Footer", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setTabFooter(player, "&9Добро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Footer", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setTabFooter(player, "&eДобро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Footer", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setTabFooter(player, "&6Добро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Footer", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setTabFooter(player, "&aДобро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Footer", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setTabFooter(player, "&dДобро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Footer", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setTabFooter(player, "&4Добро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Footer", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setTabFooter(player, "&0Добро пожаловать на сервер!");
                    sendMessage(player, "Footer установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки управления
        builder.button(createButton("✅ Применить", NamedTextColor.GREEN, TextDecoration.BOLD), 
                (clicker, result) -> {
                    applyTabSettings(player);
                    sendMessage(player, "Настройки таба применены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔁 Сбросить", NamedTextColor.YELLOW, TextDecoration.BOLD), 
                (clicker, result) -> {
                    resetTabSettings(player);
                    sendMessage(player, "Настройки таба сброшены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("❌ Отмена", NamedTextColor.RED, TextDecoration.BOLD), 
                (clicker, result) -> {
                    sendMessage(player, "Настройки отменены!");
                    return Dialog.ActionResult.close();
                });
    }
    
    private void setTabHeader(Player player, String header) {
        String action = getString("actions.header", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%header%", header));
        }
    }
    
    private void setTabFooter(Player player, String footer) {
        String action = getString("actions.footer", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%footer%", footer));
        }
    }
    
    private void applyTabSettings(Player player) {
        String action = getString("actions.apply", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
    
    private void resetTabSettings(Player player) {
        String action = getString("actions.reset", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
}