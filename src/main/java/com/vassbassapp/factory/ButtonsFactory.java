package com.vassbassapp.factory;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.*;

public class ButtonsFactory {
    /**
     * Creates buttons from Map
     * @param buttons key - button_id, value - button_name(visible)
     * @return buttons markup
     */
    public static InlineKeyboardMarkup createButtons(Map<String, String> buttons) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        for (Map.Entry<String, String> entry : buttons.entrySet()) {
            String btnId = entry.getKey();
            String btnName = entry.getValue();

            InlineKeyboardButton btn = new InlineKeyboardButton();
            btn.setCallbackData(btnId);
            btn.setText(btnName);

            keyboard.add(List.of(btn));
        }

        markup.setKeyboard(keyboard);
        return markup;
    }
}
