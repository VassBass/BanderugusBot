package com.vassbassapp.service.bot.response;

import com.vassbassapp.resources.BandergusResourceHolder;
import com.vassbassapp.util.StringHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;

public class ResponseBandergusLevelFinal implements Response {
    private final BandergusResourceHolder resourceHolder = BandergusResourceHolder.getInstance();
    private final Long chatId;

    public ResponseBandergusLevelFinal(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public SendMessage getMessage() {
        String message = "*Джавелін твій. Повний вперед!*";

        SendMessage result = new SendMessage();
        result.setChatId(chatId);
        result.setText(StringHelper.getUTF_8(message));
        result.setParseMode("markdown");

        return result;
    }

    @Override
    public SendAnimation getAnimation() {
        SendAnimation animation = new SendAnimation();
        animation.setChatId(chatId);

        InputFile inputFile = new InputFile(resourceHolder.imageLevelFinal());
        animation.setAnimation(inputFile);

        return animation;
    }
}
