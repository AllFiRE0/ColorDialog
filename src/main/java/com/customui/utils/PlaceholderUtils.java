package com.customui.utils;

import com.customui.CustomUIPlugin;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceholderUtils {
    
    private final CustomUIPlugin plugin;
    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("%([^%]+)%");
    
    public PlaceholderUtils(CustomUIPlugin plugin) {
        this.plugin = plugin;
    }
    
    /**
     * Парсит плейсхолдеры в тексте для игрока
     * @param player Игрок
     * @param text Текст с плейсхолдерами
     * @return Обработанный текст
     */
    public String parsePlaceholders(Player player, String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        
        // Если PlaceholderAPI доступен, используем его
        if (plugin.isPlaceholderAPIEnabled()) {
            return PlaceholderAPI.setPlaceholders(player, text);
        }
        
        // Иначе используем собственную обработку
        return parseCustomPlaceholders(player, text);
    }
    
    /**
     * Парсит собственные плейсхолдеры плагина
     * @param player Игрок
     * @param text Текст с плейсхолдерами
     * @return Обработанный текст
     */
    private String parseCustomPlaceholders(Player player, String text) {
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(text);
        StringBuffer result = new StringBuffer();
        
        while (matcher.find()) {
            String placeholder = matcher.group(1);
            String replacement = getCustomPlaceholder(player, placeholder);
            matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(result);
        
        return result.toString();
    }
    
    /**
     * Получает значение собственного плейсхолдера
     * @param player Игрок
     * @param placeholder Название плейсхолдера
     * @return Значение плейсхолдера
     */
    private String getCustomPlaceholder(Player player, String placeholder) {
        switch (placeholder.toLowerCase()) {
            // Основные плейсхолдеры игрока
            case "player":
            case "player_name":
                return player.getName();
            case "player_displayname":
                return player.getDisplayName();
            case "player_uuid":
                return player.getUniqueId().toString();
            case "world":
            case "player_world":
                return player.getWorld().getName();
            case "level":
            case "player_level":
                return String.valueOf(player.getLevel());
            case "exp":
            case "player_exp":
                return String.valueOf(player.getTotalExperience());
            case "health":
            case "player_health":
                return String.valueOf((int) player.getHealth());
            case "max_health":
            case "player_max_health":
                return String.valueOf((int) player.getMaxHealth());
            case "food":
            case "player_food":
                return String.valueOf(player.getFoodLevel());
            case "gamemode":
            case "player_gamemode":
                return player.getGameMode().name();
            case "ping":
            case "player_ping":
                return String.valueOf(player.getPing());
            case "view_distance":
            case "player_view_distance":
                return String.valueOf(player.getClientViewDistance());
                
            // Серверные плейсхолдеры
            case "server_name":
                return plugin.getServer().getName();
            case "server_version":
                return plugin.getServer().getVersion();
            case "online":
            case "server_online":
                return String.valueOf(plugin.getServer().getOnlinePlayers().size());
            case "max_players":
            case "server_max_players":
                return String.valueOf(plugin.getServer().getMaxPlayers());
                
            // Плейсхолдеры времени
            case "time_hour":
                return String.valueOf(java.time.LocalTime.now().getHour());
            case "time_minute":
                return String.valueOf(java.time.LocalTime.now().getMinute());
            case "time_second":
                return String.valueOf(java.time.LocalTime.now().getSecond());
            case "date_year":
                return String.valueOf(java.time.LocalDate.now().getYear());
            case "date_month":
                return String.valueOf(java.time.LocalDate.now().getMonthValue());
            case "date_day":
                return String.valueOf(java.time.LocalDate.now().getDayOfMonth());
            case "date_day_of_week":
                return java.time.LocalDate.now().getDayOfWeek().name();
                
            // LuckPerms плейсхолдеры (если доступны)
            case "prefix":
            case "luckperms_prefix":
                return getLuckPermsPrefix(player);
            case "suffix":
            case "luckperms_suffix":
                return getLuckPermsSuffix(player);
            case "group":
            case "luckperms_primary_group":
                return getLuckPermsPrimaryGroup(player);
            case "groups":
            case "luckperms_groups":
                return getLuckPermsGroups(player);
                
            default:
                return "%" + placeholder + "%"; // Возвращаем как есть, если не знаем
        }
    }
    
    private String getLuckPermsPrefix(Player player) {
        if (plugin.getLuckPermsIntegration().isEnabled()) {
            try {
                return plugin.getLuckPermsIntegration().getPlayerPrefix(player).get();
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении префикса LuckPerms: " + e.getMessage());
            }
        }
        return "";
    }
    
    private String getLuckPermsSuffix(Player player) {
        if (plugin.getLuckPermsIntegration().isEnabled()) {
            try {
                return plugin.getLuckPermsIntegration().getPlayerSuffix(player).get();
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении суффикса LuckPerms: " + e.getMessage());
            }
        }
        return "";
    }
    
    private String getLuckPermsPrimaryGroup(Player player) {
        if (plugin.getLuckPermsIntegration().isEnabled()) {
            try {
                return plugin.getLuckPermsIntegration().getPlayerPrimaryGroup(player).get();
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении основной группы LuckPerms: " + e.getMessage());
            }
        }
        return "default";
    }
    
    private String getLuckPermsGroups(Player player) {
        if (plugin.getLuckPermsIntegration().isEnabled()) {
            try {
                String[] groups = plugin.getLuckPermsIntegration().getPlayerGroups(player).get();
                return String.join(", ", groups);
            } catch (Exception e) {
                plugin.getLogger().warning("Ошибка при получении групп LuckPerms: " + e.getMessage());
            }
        }
        return "default";
    }
    
    /**
     * Проверяет, содержит ли текст плейсхолдеры
     * @param text Текст для проверки
     * @return true, если содержит плейсхолдеры
     */
    public boolean containsPlaceholders(String text) {
        return text != null && PLACEHOLDER_PATTERN.matcher(text).find();
    }
    
    /**
     * Получает список всех плейсхолдеров в тексте
     * @param text Текст для анализа
     * @return Массив плейсхолдеров
     */
    public String[] extractPlaceholders(String text) {
        if (text == null || text.isEmpty()) {
            return new String[0];
        }
        
        return PLACEHOLDER_PATTERN.matcher(text)
                .results()
                .map(match -> match.group(1))
                .toArray(String[]::new);
    }
}