package com.vassbassapp.service.bot.response.listener;

import com.vassbassapp.factory.BandergusBiolab;
import com.vassbassapp.service.bot.response.Response;
import com.vassbassapp.service.bot.response.ResponseBandergusLevel1;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TextListener implements Listener {
    private static final String REQUEST_START = "/start";

    private static volatile TextListener instance;
    private TextListener() {}
    public static TextListener getInstance() {
        if (instance == null) {
            synchronized (TextListener.class) {
                if (instance == null) {
                    instance = new TextListener();
                }
            }
        }
        return instance;
    }

    @Override
    public Response createResponse(Long chatId, Update update) {
        String message = update.getMessage().getText();
        BandergusBiolab biolab = BandergusBiolab.getInstance();

        if (message.equals(REQUEST_START)) {
            biolab.createBanderogus(chatId);
            return new ResponseBandergusLevel1(chatId);
        }

        return null;
    }
}
