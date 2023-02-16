package com.vassbassapp.service.bot.response.listener;

import com.vassbassapp.buttons.bandergus.ButtonsId;
import com.vassbassapp.factory.BandergusBiolab;
import com.vassbassapp.model.Bandergus;
import com.vassbassapp.service.bot.response.*;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ButtonsListener implements Listener {
    private static volatile ButtonsListener instance;
    private ButtonsListener() {}
    public static ButtonsListener getInstance() {
        if (instance == null) {
            synchronized (ButtonsListener.class) {
                if (instance == null) {
                    instance = new ButtonsListener();
                }
            }
        }
        return instance;
    }

    //It's singleton too
    @Override
    public Response createResponse(Long chatId, Update update) {
        final String buttonId = update.getCallbackQuery().getData();
        Bandergus bandergus = BandergusBiolab.getInstance().getBandergus(chatId);

        if (bandergus != null) {
            if (buttonId.equals(ButtonsId.getIdForTaskLevel(1))) {
                if (bandergus.getLevel() == 1) {
                    bandergus.levelUp();
                    return new ResponseBandergusLevel2(chatId);
                }
            }

            if (buttonId.equals(ButtonsId.getIdForTaskLevel(2))) {
                if (bandergus.getLevel() == 2) {
                    bandergus.levelUp();
                    return new ResponseBandergusLevel3(chatId);
                }
            }

            if (buttonId.equals(ButtonsId.getIdForTaskLevel(3))) {
                if (bandergus.getLevel() == 3) {
                    bandergus.levelUp();
                    return new ResponseBandergusLevel4(chatId);
                }
            }

            if (buttonId.equals(ButtonsId.getIdForTaskLevel(4))) {
                if (bandergus.getLevel() == 4) {
                    bandergus.levelUp();
                    return new ResponseBandergusLevelFinal(chatId);
                }
            }
        }

        return null;
    }
}
