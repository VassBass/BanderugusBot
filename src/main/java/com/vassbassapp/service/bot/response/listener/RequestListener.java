package com.vassbassapp.service.bot.response.listener;

import com.vassbassapp.service.bot.response.Response;
import org.telegram.telegrambots.meta.api.objects.Update;

public class RequestListener implements Listener {
    private static volatile RequestListener instance;
    private RequestListener() {}
    public static RequestListener getInstance() {
        if (instance == null) {
            synchronized (RequestListener.class) {
                if (instance == null) {
                    instance = new RequestListener();
                }
            }
        }
        return instance;
    }

    @Override
    public Response createResponse(Long chatId, Update update) {
        if (update.hasMessage()) {
            return TextListener.getInstance().createResponse(chatId, update);
        } else if (update.hasCallbackQuery()) {
            return ButtonsListener.getInstance().createResponse(chatId, update);
        }

        return null;
    }
}
