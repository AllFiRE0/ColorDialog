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

public class ScoreboardMenuDialog extends BaseMenuDialog {
    
    public ScoreboardMenuDialog(CustomUIPlugin plugin, ConfigManager configManager) {
        super(plugin, configManager, "scoreboard");
    }
    
    public ScoreboardMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, FileConfiguration config) {
        super(plugin, configManager, "scoreboard", config);
    }
    
    @Override
    protected void addButtons(DialogBuilder builder, Player player) {
        // Кнопки для настройки заголовка скорборда
        builder.button(createButton("🟥 Красный Заголовок", NamedTextColor.RED), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&c&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Заголовок", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&9&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Заголовок", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&e&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Заголовок", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&6&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Заголовок", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&a&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Заголовок", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&d&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Заголовок", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&4&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Заголовок", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setScoreboardTitle(player, "&0&lВаш Сервер");
                    sendMessage(player, "Заголовок скорборда установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки линий скорборда
        builder.button(createButton("🟥 Красные Линии", NamedTextColor.RED), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&c━━━━━━━━━━━━━━━━━━",
                        "&cИгрок: &f%player%",
                        "&cУровень: &f%level%",
                        "&cБаланс: &f%balance%",
                        "&c━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синие Линии", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&9━━━━━━━━━━━━━━━━━━",
                        "&9Игрок: &f%player%",
                        "&9Уровень: &f%level%",
                        "&9Баланс: &f%balance%",
                        "&9━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтые Линии", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&e━━━━━━━━━━━━━━━━━━",
                        "&eИгрок: &f%player%",
                        "&eУровень: &f%level%",
                        "&eБаланс: &f%balance%",
                        "&e━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевые Линии", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&6━━━━━━━━━━━━━━━━━━",
                        "&6Игрок: &f%player%",
                        "&6Уровень: &f%level%",
                        "&6Баланс: &f%balance%",
                        "&6━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленые Линии", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&a━━━━━━━━━━━━━━━━━━",
                        "&aИгрок: &f%player%",
                        "&aУровень: &f%level%",
                        "&aБаланс: &f%balance%",
                        "&a━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовые Линии", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&d━━━━━━━━━━━━━━━━━━",
                        "&dИгрок: &f%player%",
                        "&dУровень: &f%level%",
                        "&dБаланс: &f%balance%",
                        "&d━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневые Линии", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&4━━━━━━━━━━━━━━━━━━",
                        "&4Игрок: &f%player%",
                        "&4Уровень: &f%level%",
                        "&4Баланс: &f%balance%",
                        "&4━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черные Линии", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setScoreboardLines(player, new String[]{
                        "&0━━━━━━━━━━━━━━━━━━",
                        "&0Игрок: &f%player%",
                        "&0Уровень: &f%level%",
                        "&0Баланс: &f%balance%",
                        "&0━━━━━━━━━━━━━━━━━━"
                    });
                    sendMessage(player, "Линии скорборда установлены на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки управления
        builder.button(createButton("✅ Применить", NamedTextColor.GREEN, TextDecoration.BOLD), 
                (clicker, result) -> {
                    applyScoreboardSettings(player);
                    sendMessage(player, "Настройки скорборда применены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔁 Сбросить", NamedTextColor.YELLOW, TextDecoration.BOLD), 
                (clicker, result) -> {
                    resetScoreboardSettings(player);
                    sendMessage(player, "Настройки скорборда сброшены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("❌ Отмена", NamedTextColor.RED, TextDecoration.BOLD), 
                (clicker, result) -> {
                    sendMessage(player, "Настройки отменены!");
                    return Dialog.ActionResult.close();
                });
    }
    
    private void setScoreboardTitle(Player player, String title) {
        String action = getString("actions.title", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%title%", title));
        }
    }
    
    private void setScoreboardLines(Player player, String[] lines) {
        String action = getString("actions.lines", "");
        if (!action.isEmpty()) {
            StringBuilder linesStr = new StringBuilder();
            for (int i = 0; i < lines.length; i++) {
                linesStr.append(lines[i]);
                if (i < lines.length - 1) {
                    linesStr.append("\\n");
                }
            }
            executeAction(player, action.replace("%lines%", linesStr.toString()));
        }
    }
    
    private void applyScoreboardSettings(Player player) {
        String action = getString("actions.apply", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
    
    private void resetScoreboardSettings(Player player) {
        String action = getString("actions.reset", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
}