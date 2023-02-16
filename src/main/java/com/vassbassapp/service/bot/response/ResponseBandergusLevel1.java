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

public class ResponseBandergusLevel1 implements Response {
    private final BandergusResourceHolder resourceHolder = BandergusResourceHolder.getInstance();
    private final Long chatId;

    public ResponseBandergusLevel1(Long chatId) {
        this.chatId = chatId;
    }

    @Override
    public SendMessage getMessage() {
        String message = "Ґа-ґа-ґа!" +
                "\nВітаємо у боті біолабораторії «Батько наш Бандера»." +
                "\n\n" +
                "Ти отримуєш гусака №71" +
                "\n\nЦей бот ми створили для того, щоб твій гусак прокачався з рівня звичайної свійської худоби" +
                " до рівня біологічної зброї, здатної нищити ворога." +
                "\n\nЩоб звичайний гусак перетворився на бандерогусака, тобі необхідно:" +
                "\n✔️виконувати завдання" +
                "\n✔️переходити на наступні рівні" +
                "\n✔️заробити достатню кількість монет, щоб придбати Джавеліну і зробити свєрхтра-та-та." +
                "\n\n*Гусак звичайний.* Стартовий рівень." +
                "\nБонус: 5 монет." +
                "\nОбери завдання, щоб перейти на наступний рівень";

        String task1 = "Сплести маскувальну сітку (+15 монет)";
        String task2 = "Зібрати кошти патріотичними піснями (+15 монет)";
        String task3 = "Вступити в Міністерство Мемів України (+15 монет)";
        String task4 = "Запустити волонтерську акцію (+15 монет)";
        String task5  = "Вступити до лав тероборони (+15 монет)";

        List<InlineKeyboardButton> row1 = List.of(new ButtonTask(1, task1));
        List<InlineKeyboardButton> row2 = List.of(new ButtonTask(1, task2));
        List<InlineKeyboardButton> row3 = List.of(new ButtonTask(1, task3));
        List<InlineKeyboardButton> row4 = List.of(new ButtonTask(1, task4));
        List<InlineKeyboardButton> row5 = List.of(new ButtonTask(1, task5));

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

        InputFile inputFile = new InputFile(resourceHolder.imageLevel1());
        animation.setAnimation(inputFile);

        return animation;
    }
}
