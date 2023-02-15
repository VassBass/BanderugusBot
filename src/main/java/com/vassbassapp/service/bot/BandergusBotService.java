package com.vassbassapp.service.bot;

import com.vassbassapp.config.APIConfigHolder;
import com.vassbassapp.service.bot.response.SessionGenerator;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
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
        Long chatId = getChatId(update);
        if (chatId != null) {
            SendMessage session = SessionGenerator.createSession(chatId, update);
            sendApiMethodAsync(session);
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
