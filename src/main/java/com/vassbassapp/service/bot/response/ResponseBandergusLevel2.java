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

public class ResponseBandergusLevel2 implements Response {
    private final BandergusResourceHolder resourceHolder = BandergusResourceHolder.getInstance();
    private final Long chatId;

    public ResponseBandergusLevel2(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public SendMessage getMessage() {
        String message = "*Вітаємо на другому рівні! Твій гусак - біогусак.*" +
                "\nБаланс: 20 монет." +
                "\nОбери завдання, щоб перейти на наступний рівень";

        String task1 = "Зібрати комарів для нової біологічної зброї (+15 монет)";
        String task2 = "Пройти курс молодого бійця (+15 монет)";
        String task3 = "Задонатити на ЗСУ (+15 монет)";
        String task4 = "Збити дрона банкою огірків (+15 монет)";
        String task5  = "Зробити запаси коктейлів Молотова (+15 монет)";

        List<InlineKeyboardButton> row1 = List.of(new ButtonTask(2, task1));
        List<InlineKeyboardButton> row2 = List.of(new ButtonTask(2, task2));
        List<InlineKeyboardButton> row3 = List.of(new ButtonTask(2, task3));
        List<InlineKeyboardButton> row4 = List.of(new ButtonTask(2, task4));
        List<InlineKeyboardButton> row5 = List.of(new ButtonTask(2, task5));

        SendMessage result = new SendMessage();
        result.setChatId(chatId);
        result.setText(StringHelper.getUTF_8(message));
        result.setParseMode("markdown");
        result.setReplyMarkup(ButtonsFactory.createButtons(row1, row2, row3, row4, row5));

        return result;
    }

    @Override
    public SendAnimation getAnimation() {
        SendAnimation animation = new SendAnimation();
        animation.setChatId(chatId);

        InputFile inputFile = new InputFile(resourceHolder.imageLevel2());
        animation.setAnimation(inputFile);

        return animation;
    }
}
