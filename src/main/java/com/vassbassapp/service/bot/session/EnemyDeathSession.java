package com.vassbassapp.service.bot.session;

import com.vassbassapp.util.StringUTF_8;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class EnemyDeathSession extends SendMessage {
    private static final String TEXT_MESSAGE = "Смерть ворогам!";

    public EnemyDeathSession(Long chatId) {
        super();
        this.setChatId(chatId);
        this.setText(StringUTF_8.get(TEXT_MESSAGE));
    }
}
