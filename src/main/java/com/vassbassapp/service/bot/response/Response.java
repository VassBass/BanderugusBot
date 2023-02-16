package com.vassbassapp.service.bot.response;

import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface Response {
    SendMessage getMessage();
    SendAnimation getAnimation();
}
