package com.vassbassapp.service.bot;

import com.vassbassapp.config.APIConfigHolder;
import com.vassbassapp.service.bot.response.Response;
import com.vassbassapp.service.bot.response.listener.Listener;
import com.vassbassapp.service.bot.response.listener.RequestListener;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BandergusBotService extends TelegramLongPollingBot {

    private final APIConfigHolder configHolder;

    public BandergusBotService(APIConfigHolder configHolder) {
        this.configHolder = configHolder;
    }

    @Override
    public String getBotUsername() {
        return configHolder.getUserName();
    }

    @Override
    public String getBotToken() {
        return configHolder.getApiToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        Listener requestListener = RequestListener.getInstance();

        Long chatId = getChatId(update);
        if (chatId != null) {
            Response response = requestListener.createResponse(chatId, update);
            if (response != null) {
                SendAnimation animation = response.getAnimation();
                SendMessage message = response.getMessage();

                if (animation != null) executeAsync(animation);
                if (message != null) sendApiMethodAsync(message);
            }
        }
    }

    private Long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId();
        }
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }
}
