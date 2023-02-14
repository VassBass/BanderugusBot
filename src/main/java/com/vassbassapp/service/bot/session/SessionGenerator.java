package com.vassbassapp.service.bot.session;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SessionGenerator {
    private static final String REQUEST_START = "/start";
    private static final String REQUEST_GLORY_FOR_UKRAINE = "glory_for_ukraine";
    private static final String REQUEST_GLORY_FOR_NATION = "glory_for_nation";

    public static SendMessage createSession(Long chatId, Update update) {
        SendMessage session = null;

        if (update.hasMessage()) {
            String message = update.getMessage().getText();
            session = generateForText(chatId, message);
        } else if (update.hasCallbackQuery()) {
            switch (update.getCallbackQuery().getData()) {
                case REQUEST_GLORY_FOR_UKRAINE:
                    session = new HeroGlorySession(chatId);
                    break;
                case REQUEST_GLORY_FOR_NATION:
                    session = new EnemyDeathSession(chatId);
                    break;
            }
        }

        return session == null ?
                defaultSession(chatId) :
                session;
    }

    private static SendMessage generateForText(Long chatId, String text) {
        switch (text) {
            case REQUEST_START: return new HelloSession(chatId);
            default: return null;
        }
    }

    private static SendMessage defaultSession(Long chatId) {
        String m = "Sorry, I have no reaction to this action.";
        SendMessage session = new SendMessage();
        session.setChatId(chatId);
        session.setText(m);
        return session;
    }
}
