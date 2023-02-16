package com.vassbassapp.service.bot.response.listener;

import com.vassbassapp.service.bot.response.Response;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Listener {
    Response createResponse(Long chatId, Update update);
}
