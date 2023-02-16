package com.vassbassapp.factory;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ButtonsFactory {
    private ButtonsFactory(){}

    @SafeVarargs
    public static InlineKeyboardMarkup createButtons(List<InlineKeyboardButton> ... row) {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>(Arrays.asList(row));
        markup.setKeyboard(keyboard);
        return markup;
    }
}
