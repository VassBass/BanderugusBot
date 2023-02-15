package com.vassbassapp.service.bot.response;

import com.vassbassapp.factory.ButtonsFactory;
import com.vassbassapp.util.StringHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.Map;

public class ResponseHeroGlory extends SendMessage {
    private static final String TEXT_MESSAGE = "Героям Слава!";

    private static final String BTN_NAME_GLORY = "Слава Нації!";
    private static final String BTN_ID_GLORY = "glory_for_nation";

    public ResponseHeroGlory(Long chatId) {
        super();
        this.setChatId(chatId);
        this.setText(StringHelper.getUTF_8(TEXT_MESSAGE));

        Map<String, String> buttons = Map.of(
                BTN_ID_GLORY, StringHelper.getUTF_8(BTN_NAME_GLORY)
        );
        this.setReplyMarkup(ButtonsFactory.createButtons(buttons));
    }
}
