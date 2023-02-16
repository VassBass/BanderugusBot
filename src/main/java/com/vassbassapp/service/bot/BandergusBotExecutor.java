package com.vassbassapp.service.bot;

import com.vassbassapp.resources.BandergusResourceHolder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BandergusBotExecutor implements BotExecutor {

    private final TelegramLongPollingBot bot;

    public BandergusBotExecutor(TelegramLongPollingBot bot) {
        this.bot = bot;
    }

    @Override
    public void execute() {
        try {
            BandergusResourceHolder.getInstance().readResources();
            TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
            api.registerBot(bot);
            System.out.printf("%s service was started successful!%n", bot.getBotUsername());
        } catch (TelegramApiException e) {
            String message = "Error via bot service starting!";
            throw new RuntimeException(message, e);
        }

    }
}
