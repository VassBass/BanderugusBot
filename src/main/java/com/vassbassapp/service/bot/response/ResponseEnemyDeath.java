package com.vassbassapp.service.bot.response;

import com.vassbassapp.util.StringHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class ResponseEnemyDeath extends SendMessage {
    private static final String TEXT_MESSAGE = "Смерть ворогам!";

    public ResponseEnemyDeath(Long chatId) {
        super();
        this.setChatId(chatId);
        this.setText(StringHelper.getUTF_8(TEXT_MESSAGE));
    }
}
