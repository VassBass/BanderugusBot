package com.vassbassapp.service.bot.response;

import com.vassbassapp.buttons.bandergus.ButtonTask;
import com.vassbassapp.factory.ButtonsFactory;
import com.vassbassapp.resources.BandergusResourceHolder;
import com.vassbassapp.util.StringHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ResponseBandergusLevel4 implements Response {
    private final BandergusResourceHolder resourceHolder = BandergusResourceHolder.getInstance();
    private final Long chatId;

    public ResponseBandergusLevel4(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public SendMessage getMessage() {
        String message = "*Вітаємо на останньому рівні! Твій гусак - готова біологічна зброя - бандерогусак.*" +
                "\nБаланс: 50 монет." +
                "\nТепер ти можеш придбати Джавелін і глушити чмонь";

        String task1 = "Купити Джавелін (50 монет)";

        List<InlineKeyboardButton> row1 = List.of(new ButtonTask(4, task1));

        SendMessage result = new SendMessage();
        result.setChatId(chatId);
        result.setText(StringHelper.getUTF_8(message));
        result.setParseMode("markdown");
        result.setReplyMarkup(ButtonsFactory.createButtons(row1));

        return result;
    }

    @Override
    public SendAnimation getAnimation() {
        SendAnimation animation = new SendAnimation();
        animation.setChatId(chatId);

        InputFile inputFile = new InputFile(resourceHolder.imageLevel4());
        animation.setAnimation(inputFile);

        return animation;
    }
}
