package com.vassbassapp.service.bot;

import com.vassbassapp.config.APIConfigHolder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class BandergusBotService extends TelegramLongPollingBot implements BotService {

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
            SendMessage msg = createMessage("*Hello* Ihor!");
            msg.setChatId(chatId);
            sendApiMethodAsync(msg);
        }
    }

    @Override
    public Long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId();
        }
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }

    @Override
    public SendMessage createMessage(String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setParseMode("markdown");
        return message;
    }
}
