package com.vassbassapp;

import com.vassbassapp.factory.TelegramBotFactory;
import com.vassbassapp.service.bot.BandergusBotService;

public class Main {

    public static void main(String[] args) {
        TelegramBotFactory botFactory = TelegramBotFactory.getInstance();
        BandergusBotService bot = botFactory.create(BandergusBotService.class);
    }
}