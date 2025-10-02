package com.customui.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.ChatColor;

public class ChatColorUtils {
    
    /**
     * Переводит цветовые коды в компонент Adventure
     */
    public static Component translateAlternateColorCodes(char altColorChar, String textToTranslate) {
        return LegacyComponentSerializer.legacySection().deserialize(textToTranslate.replace(altColorChar, '§'));
    }
    
    /**
     * Переводит цветовые коды в строку с Bukkit ChatColor
     */
    public static String translateAlternateColorCodes(char altColorChar, String textToTranslate) {
        return ChatColor.translateAlternateColorCodes(altColorChar, textToTranslate);
    }
    
    /**
     * Убирает все цветовые коды из текста
     */
    public static String stripColorCodes(String text) {
        return ChatColor.stripColor(text);
    }
    
    /**
     * Проверяет содержит ли текст цветовые коды
     */
    public static boolean hasColorCodes(String text) {
        return text.contains("§") || text.contains("&");
    }
    
    /**
     * Конвертирует Bukkit ChatColor в Adventure NamedTextColor
     */
    public static NamedTextColor toAdventureColor(ChatColor bukkitColor) {
        switch (bukkitColor) {
            case BLACK: return NamedTextColor.BLACK;
            case DARK_BLUE: return NamedTextColor.DARK_BLUE;
            case DARK_GREEN: return NamedTextColor.DARK_GREEN;
            case DARK_AQUA: return NamedTextColor.DARK_AQUA;
            case DARK_RED: return NamedTextColor.DARK_RED;
            case DARK_PURPLE: return NamedTextColor.DARK_PURPLE;
            case GOLD: return NamedTextColor.GOLD;
            case GRAY: return NamedTextColor.GRAY;
            case DARK_GRAY: return NamedTextColor.DARK_GRAY;
            case BLUE: return NamedTextColor.BLUE;
            case GREEN: return NamedTextColor.GREEN;
            case AQUA: return NamedTextColor.AQUA;
            case RED: return NamedTextColor.RED;
            case LIGHT_PURPLE: return NamedTextColor.LIGHT_PURPLE;
            case YELLOW: return NamedTextColor.YELLOW;
            case WHITE: return NamedTextColor.WHITE;
            default: return NamedTextColor.WHITE;
        }
    }
    
    /**
     * Конвертирует Bukkit ChatColor в Adventure TextDecoration
     */
    public static TextDecoration toAdventureDecoration(ChatColor bukkitColor) {
        switch (bukkitColor) {
            case BOLD: return TextDecoration.BOLD;
            case ITALIC: return TextDecoration.ITALIC;
            case UNDERLINE: return TextDecoration.UNDERLINED;
            case STRIKETHROUGH: return TextDecoration.STRIKETHROUGH;
            case MAGIC: return TextDecoration.OBFUSCATED;
            default: return null;
        }
    }
    
    /**
     * Создает градиентный текст
     */
    public static String createGradient(String text, String startColor, String endColor) {
        if (text == null || text.isEmpty()) return text;
        
        StringBuilder result = new StringBuilder();
        int length = text.length();
        
        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            double ratio = (double) i / (length - 1);
            
            // Простая интерполяция цветов (упрощенная версия)
            String color = interpolateColor(startColor, endColor, ratio);
            result.append(color).append(c);
        }
        
        return result.toString();
    }
    
    /**
     * Простая интерполяция цветов
     */
    private static String interpolateColor(String startColor, String endColor, double ratio) {
        // Упрощенная версия - просто чередуем цвета
        return ratio < 0.5 ? startColor : endColor;
    }
    
    /**
     * Создает радужный текст
     */
    public static String createRainbow(String text) {
        if (text == null || text.isEmpty()) return text;
        
        String[] colors = {"&c", "&6", "&e", "&a", "&b", "&9", "&d"};
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            String color = colors[i % colors.length];
            result.append(color).append(c);
        }
        
        return result.toString();
    }
}