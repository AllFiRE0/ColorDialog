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
        // Кнопки для выбора титулов-рангов
        builder.button(createButton("👤 Игрок", NamedTextColor.WHITE), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Игрок", "&7[Игрок]");
                    sendMessage(player, "Титул установлен: Игрок");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⭐ VIP", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setPlayerTitle(player, "VIP", "&6[VIP]");
                    sendMessage(player, "Титул установлен: VIP");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("💎 Премиум", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Премиум", "&d[Премиум]");
                    sendMessage(player, "Титул установлен: Премиум");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("👑 Король", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Король", "&e[Король]");
                    sendMessage(player, "Титул установлен: Король");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🛡️ Модератор", NamedTextColor.BLUE), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Модератор", "&9[Модератор]");
                    sendMessage(player, "Титул установлен: Модератор");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("⚡ Администратор", NamedTextColor.RED), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Администратор", "&c[Администратор]");
                    sendMessage(player, "Титул установлен: Администратор");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🌟 Владелец", NamedTextColor.DARK_RED), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Владелец", "&4[Владелец]");
                    sendMessage(player, "Титул установлен: Владелец");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🎯 Специалист", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Специалист", "&a[Специалист]");
                    sendMessage(player, "Титул установлен: Специалист");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔧 Разработчик", NamedTextColor.DARK_GRAY), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Разработчик", "&8[Разработчик]");
                    sendMessage(player, "Титул установлен: Разработчик");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🎨 Дизайнер", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Дизайнер", "&d[Дизайнер]");
                    sendMessage(player, "Титул установлен: Дизайнер");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("📝 Писатель", NamedTextColor.YELLOW), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Писатель", "&e[Писатель]");
                    sendMessage(player, "Титул установлен: Писатель");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🎵 Музыкант", NamedTextColor.GREEN), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Музыкант", "&a[Музыкант]");
                    sendMessage(player, "Титул установлен: Музыкант");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🏆 Чемпион", NamedTextColor.GOLD), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Чемпион", "&6[Чемпион]");
                    sendMessage(player, "Титул установлен: Чемпион");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("🔥 Легенда", NamedTextColor.RED), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Легенда", "&c[Легенда]");
                    sendMessage(player, "Титул установлен: Легенда");
                    return Dialog.ActionResult.close();
                });
        
        builder.button(createButton("💫 Мастер", NamedTextColor.LIGHT_PURPLE), 
                (clicker, result) -> {
                    setPlayerTitle(player, "Мастер", "&d[Мастер]");
                    sendMessage(player, "Титул установлен: Мастер");
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
    
    private void setPlayerTitle(Player player, String titleName, String titlePrefix) {
        String action = getString("actions.set_title", "");
        if (!action.isEmpty()) {
            executeAction(player, action.replace("%title%", titleName).replace("%prefix%", titlePrefix));
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