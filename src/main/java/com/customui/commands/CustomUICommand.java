package com.customui.commands;

import com.customui.CustomUIPlugin;
import com.customui.menu.MenuManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomUICommand implements CommandExecutor, TabCompleter {
    
    private final CustomUIPlugin plugin;
    private final MenuManager menuManager;
    
    public CustomUICommand(CustomUIPlugin plugin, MenuManager menuManager) {
        this.plugin = plugin;
        this.menuManager = menuManager;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sendHelpMessage(sender);
            return true;
        }
        
        String subCommand = args[0].toLowerCase();
        
        switch (subCommand) {
            case "reload":
                return handleReload(sender);
            case "list":
                return handleList(sender);
            case "help":
                sendHelpMessage(sender);
                return true;
            default:
                return handleMenuOpen(sender, args);
        }
    }
    
    private boolean handleReload(CommandSender sender) {
        if (!sender.hasPermission("customui.admin")) {
            sender.sendMessage(Component.text("У вас нет прав для выполнения этой команды!")
                    .color(NamedTextColor.RED));
            return true;
        }
        
        try {
            plugin.getConfigManager().reloadConfigs();
            menuManager.reloadMenus();
            sender.sendMessage(Component.text("Конфигурация плагина перезагружена!")
                    .color(NamedTextColor.GREEN));
        } catch (Exception e) {
            sender.sendMessage(Component.text("Ошибка при перезагрузке: " + e.getMessage())
                    .color(NamedTextColor.RED));
        }
        
        return true;
    }
    
    private boolean handleList(CommandSender sender) {
        if (!sender.hasPermission("customui.use")) {
            sender.sendMessage(Component.text("У вас нет прав для выполнения этой команды!")
                    .color(NamedTextColor.RED));
            return true;
        }
        
        sender.sendMessage(Component.text("Доступные меню:")
                .color(NamedTextColor.GOLD));
        
        for (String menuName : menuManager.getAvailableMenus().keySet()) {
            sender.sendMessage(Component.text("  - " + menuName)
                    .color(NamedTextColor.YELLOW));
        }
        
        return true;
    }
    
    private boolean handleMenuOpen(CommandSender sender, String[] args) {
        if (!sender.hasPermission("customui.use")) {
            sender.sendMessage(Component.text("У вас нет прав для выполнения этой команды!")
                    .color(NamedTextColor.RED));
            return true;
        }
        
        String menuName = args[0].toLowerCase();
        Player targetPlayer;
        
        if (args.length > 1) {
            // Открытие меню для другого игрока
            if (!sender.hasPermission("customui.admin")) {
                sender.sendMessage(Component.text("У вас нет прав для открытия меню другим игрокам!")
                        .color(NamedTextColor.RED));
                return true;
            }
            
            targetPlayer = Bukkit.getPlayer(args[1]);
            if (targetPlayer == null) {
                sender.sendMessage(Component.text("Игрок '" + args[1] + "' не найден!")
                        .color(NamedTextColor.RED));
                return true;
            }
        } else {
            // Открытие меню для себя
            if (!(sender instanceof Player)) {
                sender.sendMessage(Component.text("Эта команда может быть выполнена только игроком!")
                        .color(NamedTextColor.RED));
                return true;
            }
            targetPlayer = (Player) sender;
        }
        
        if (!menuManager.hasMenu(menuName)) {
            sender.sendMessage(Component.text("Меню '" + menuName + "' не найдено!")
                    .color(NamedTextColor.RED));
            return true;
        }
        
        menuManager.openMenu(targetPlayer, menuName);
        
        if (sender != targetPlayer) {
            sender.sendMessage(Component.text("Меню '" + menuName + "' открыто для игрока " + targetPlayer.getName())
                    .color(NamedTextColor.GREEN));
        }
        
        return true;
    }
    
    private void sendHelpMessage(CommandSender sender) {
        sender.sendMessage(Component.text("=== CustomUI Plugin Help ===")
                .color(NamedTextColor.GOLD));
        sender.sendMessage(Component.text("/customui <menu> - Открыть меню")
                .color(NamedTextColor.YELLOW));
        sender.sendMessage(Component.text("/customui <menu> <player> - Открыть меню для игрока")
                .color(NamedTextColor.YELLOW));
        sender.sendMessage(Component.text("/customui list - Показать доступные меню")
                .color(NamedTextColor.YELLOW));
        sender.sendMessage(Component.text("/customui reload - Перезагрузить конфигурацию")
                .color(NamedTextColor.YELLOW));
        sender.sendMessage(Component.text("/customui help - Показать эту справку")
                .color(NamedTextColor.YELLOW));
    }
    
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        
        if (args.length == 1) {
            // Первый аргумент - команда или меню
            List<String> options = Arrays.asList("help", "list", "reload");
            options.addAll(menuManager.getAvailableMenus().keySet());
            
            for (String option : options) {
                if (option.toLowerCase().startsWith(args[0].toLowerCase())) {
                    completions.add(option);
                }
            }
        } else if (args.length == 2 && !args[0].equals("help") && !args[0].equals("list") && !args[0].equals("reload")) {
            // Второй аргумент - имя игрока (если это команда открытия меню)
            if (sender.hasPermission("customui.admin")) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
                        completions.add(player.getName());
                    }
                }
            }
        }
        
        return completions;
    }
}