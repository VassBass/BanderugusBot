package com.vassbassapp.buttons.bandergus;

import com.vassbassapp.util.StringHelper;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class ButtonTask extends InlineKeyboardButton {

    public ButtonTask(int level, String text) {
        super();
        this.setCallbackData(ButtonsId.getIdForTaskLevel(level));
        this.setText(StringHelper.getUTF_8(text));
    }
}
