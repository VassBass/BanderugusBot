package com.vassbassapp.service.bot.session;

import com.vassbassapp.factory.ButtonsFactory;
import com.vassbassapp.util.StringUTF_8;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Map;

public class HelloSession extends SendMessage {
    private static final String TEXT_MESSAGE = "Привіт!";

    private static final String BTN_NAME_GLORY = "Слава Україні!";
    private static final String BTN_ID_GLORY = "glory_for_ukraine";

    public HelloSession(Long chatId) {
        super();
        this.setChatId(chatId);
        this.setText(StringUTF_8.get(TEXT_MESSAGE));

        Map<String, String> buttons = Map.of(
                BTN_ID_GLORY, StringUTF_8.get(BTN_NAME_GLORY)
        );
        this.setReplyMarkup(ButtonsFactory.createButtons(buttons));
    }
}
