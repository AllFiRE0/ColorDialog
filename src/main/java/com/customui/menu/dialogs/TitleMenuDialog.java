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

public class TitleMenuDialog extends BaseMenuDialog {
    
    public TitleMenuDialog(CustomUIPlugin plugin, ConfigManager configManager) {
        super(plugin, configManager, "title");
    }
    
    public TitleMenuDialog(CustomUIPlugin plugin, ConfigManager configManager, FileConfiguration config) {
        super(plugin, configManager, "title", config);
    }
    
    @Override
    protected void addButtons(DialogBuilder builder, Player player) {
        // Кнопки для настройки заголовка титула
        builder.button(createButton("🟥 Красный Заголовок", NamedTextColor.RED), 
                (clicker, result) -> {
                    setTitleHeader(player, "&c&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Заголовок", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setTitleHeader(player, "&9&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Заголовок", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setTitleHeader(player, "&e&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Заголовок", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setTitleHeader(player, "&6&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Заголовок", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setTitleHeader(player, "&a&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Заголовок", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setTitleHeader(player, "&d&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Заголовок", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setTitleHeader(player, "&4&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Заголовок", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setTitleHeader(player, "&0&lДобро пожаловать!");
                    sendMessage(player, "Заголовок титула установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки подзаголовка титула
        builder.button(createButton("🟥 Красный Подзаголовок", NamedTextColor.RED), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&cНа сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на красный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟦 Синий Подзаголовок", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&9На сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на синий цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟨 Желтый Подзаголовок", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&eНа сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на желтый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟧 Оранжевый Подзаголовок", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&6На сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на оранжевый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟩 Зеленый Подзаголовок", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&aНа сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на зеленый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟪 Фиолетовый Подзаголовок", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&dНа сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на фиолетовый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🟫 Коричневый Подзаголовок", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&4На сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на коричневый цвет!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⬛ Черный Подзаголовок", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setTitleSubtitle(player, "&0На сервер!");
                    sendMessage(player, "Подзаголовок титула установлен на черный цвет!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки времени отображения титула
        builder.button(createButton("⏱️ Быстрое Отображение", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setTitleTiming(player, "fast");
                    sendMessage(player, "Время отображения титула установлено на быстрое!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⏰ Обычное Отображение", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setTitleTiming(player, "normal");
                    sendMessage(player, "Время отображения титула установлено на обычное!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⏳ Медленное Отображение", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setTitleTiming(player, "slow");
                    sendMessage(player, "Время отображения титула установлено на медленное!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки для настройки эффектов титула
        builder.button(createButton("✨ Эффект Fade In", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setTitleEffect(player, "fadein");
                    sendMessage(player, "Эффект титула установлен на Fade In!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🌟 Эффект Fade Out", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setTitleEffect(player, "fadeout");
                    sendMessage(player, "Эффект титула установлен на Fade Out!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("💫 Эффект Stay", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setTitleEffect(player, "stay");
                    sendMessage(player, "Эффект титула установлен на Stay!");
                    return Dialog.ActionResult.close();
                });
        
        // Кнопки управления
        builder.button(createButton("✅ Применить", NamedTextColor.GREEN, TextDecoration.BOLD), 
                (clicker, result) -> {
                    applyTitleSettings(player);
                    sendMessage(player, "Настройки титула применены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔁 Сбросить", NamedTextColor.YELLOW, TextDecoration.BOLD), 
                (clicker, result) -> {
                    resetTitleSettings(player);
                    sendMessage(player, "Настройки титула сброшены!");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("❌ Отмена", NamedTextColor.RED, TextDecoration.BOLD), 
                (clicker, result) -> {
                    sendMessage(player, "Настройки отменены!");
                    return Dialog.ActionResult.close();
                });
    }
    
    private void setTitleHeader(Player player, String header) {
        String action = getString("actions.header", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%header%", header));
        }
    }
    
    private void setTitleSubtitle(Player player, String subtitle) {
        String action = getString("actions.subtitle", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%subtitle%", subtitle));
        }
    }
    
    private void setTitleTiming(Player player, String timing) {
        String action = getString("actions.timing", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%timing%", timing));
        }
    }
    
    private void setTitleEffect(Player player, String effect) {
        String action = getString("actions.effect", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%effect%", effect));
        }
    }
    
    private void applyTitleSettings(Player player) {
        String action = getString("actions.apply", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
    
    private void resetTitleSettings(Player player) {
        String action = getString("actions.reset", "");
        if (!action.isEmpty()) {
            executeAction(player, action);
        }
    }
}