package com.vassbassapp.factory;

import com.vassbassapp.config.APIConfigHolder;
import com.vassbassapp.config.DefaultAPIConfigHolder;
import com.vassbassapp.service.bot.BandergusBotExecutor;
import com.vassbassapp.service.bot.BandergusBotService;

public class TelegramBotFactory {
    private static volatile TelegramBotFactory instance;
    private TelegramBotFactory(APIConfigHolder configHolder) {
        this.configHolder = configHolder;
    }
    public static TelegramBotFactory getInstance() {
        if (instance == null) {
            synchronized (TelegramBotFactory.class) {
                if (instance == null) {
                    APIConfigHolder config = new DefaultAPIConfigHolder();
                    instance = new TelegramBotFactory(config);
                }
            }
        }
        return instance;
    }

    private final APIConfigHolder configHolder;

    @SuppressWarnings("unchecked")
    public <T> T create(Class<T> clazz) {
        if (clazz.isAssignableFrom(BandergusBotService.class)) {
            BandergusBotService service = new BandergusBotService(configHolder);
            new BandergusBotExecutor(service).execute();
            return (T) service;
        }

        System.err.println("Implementation of bot not found!");
        return null;
    }
}
