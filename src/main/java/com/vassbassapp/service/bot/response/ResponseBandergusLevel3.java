package com.vassbassapp.service.bot.response;

import com.vassbassapp.buttons.bandergus.ButtonTask;
import com.vassbassapp.factory.ButtonsFactory;
import com.vassbassapp.resources.BandergusResourceHolder;
import com.vassbassapp.util.CollectionHelper;
import com.vassbassapp.util.StringHelper;
import org.telegram.telegrambots.meta.api.methods.send.SendAnimation;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class ResponseBandergusLevel3 implements Response {
    private final BandergusResourceHolder resourceHolder = BandergusResourceHolder.getInstance();
    private final Long chatId;

    public ResponseBandergusLevel3(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public SendMessage getMessage() {
        String message = "*Вітаємо на третьому рівні! Твій гусак - бандеростажер.*" +
                "\nБаланс: 35 монет." +
                "\nОбери завдання, щоб перейти на наступний рівень";

        String task1 = "Злітати на тестовий рейд по чотирьох позиціях (+15 монет)";
        String task2 = "Відвезти гуманітарку на передок (+15 монет)";
        String task3 = "Знайти зрадника та здати в СБУ (+15 монет)";
        String task4 = "Навести арту на орків (+15 монет)";
        String task5  = "Притягнути танк трактором (+15 монет)";

        List<InlineKeyboardButton> row1 = List.of(new ButtonTask(3, task1));
        List<InlineKeyboardButton> row2 = List.of(new ButtonTask(3, task2));
        List<InlineKeyboardButton> row3 = List.of(new ButtonTask(3, task3));
        List<InlineKeyboardButton> row4 = List.of(new ButtonTask(3, task4));
        List<InlineKeyboardButton> row5 = List.of(new ButtonTask(3, task5));

        List<List<InlineKeyboardButton>> allKeys = List.of(row1, row2, row3, row4, row5);
        List<List<InlineKeyboardButton>> randomKeys = new CollectionHelper<>(allKeys).getRandom(3);

        SendMessage result = new SendMessage();
        result.setChatId(chatId);
        result.setText(StringHelper.getUTF_8(message));
        result.setParseMode("markdown");
        result.setReplyMarkup(ButtonsFactory.createButtons(randomKeys));

        return result;
    }

    @Override
    public SendAnimation getAnimation() {
        SendAnimation animation = new SendAnimation();
        animation.setChatId(chatId);

        InputFile inputFile = new InputFile(resourceHolder.imageLevel3());
        animation.setAnimation(inputFile);

        return animation;
    }
}
