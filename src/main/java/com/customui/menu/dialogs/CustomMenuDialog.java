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

import java.util.List;

public class CustomMenuDialog extends BaseMenuDialog {
    
    public CustomMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, String menuName, FileConfiguration config) {
        super(plugin, configManager, menuName, config);
    }
    
    @Override
    protected void addButtons(DialogBuilder builder, Player player) {
        List<String> buttons = getStringList("buttons");
        
        for (String buttonConfig : buttons) {
            String[] parts = buttonConfig.split(":");
            if (parts.length >= 2) {
                String buttonText = parts[0];
                String buttonAction = parts[1];
                String buttonColor = parts.length > 2 ? parts[2] : "WHITE";
                
                NamedTextColor color = parseColor(buttonColor);
                Component buttonComponent = createButton(buttonText, color);
                
                builder.button(buttonComponent, (clicker, result) -> {
                    executeAction(player, buttonAction);
                    sendMessage(player, "Действие выполнено: " + buttonText);
                    return Dialog.ActionResult.close();
                });
            }
        }
        
        // Добавляем стандартные кнопки управления если они не определены
        if (buttons.isEmpty()) {
            builder.button(createButton("✅ Применить", NamedTextColor.GREEN, TextDecoration.BOLD), 
                    (clicker, result) -> {
                        String action = getString("actions.apply", "");
                        if (!action.isEmpty()) {
                            executeAction(player, action);
                        }
                        sendMessage(player, "Настройки применены!");
                        return Dialog.ActionResult.close();
                    });
            
            builder.button(createButton("🔁 Сбросить", NamedTextColor.YELLOW, TextDecoration.BOLD), 
                    (clicker, result) -> {
                        String action = getString("actions.reset", "");
                        if (!action.isEmpty()) {
                            executeAction(player, action);
                        }
                        sendMessage(player, "Настройки сброшены!");
                        return Dialog.ActionResult.close();
                    });
            
            builder.button(createButton("❌ Отмена", NamedTextColor.RED, TextDecoration.BOLD), 
                    (clicker, result) -> {
                        sendMessage(player, "Настройки отменены!");
                        return Dialog.ActionResult.close();
                    });
        }
    }
    
    private NamedTextColor parseColor(String colorName) {
        try {
            return NamedTextColor.valueOf(colorName.toUpperCase());
        } catch (IllegalArgumentException e) {
            return NamedTextColor.WHITE;
        }
    }
}