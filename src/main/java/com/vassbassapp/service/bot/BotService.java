package com.vassbassapp.service.bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotService {
    Long getChatId(Update update);
    SendMessage createMessage(String text);
}
