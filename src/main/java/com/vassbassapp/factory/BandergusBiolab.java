package com.vassbassapp.factory;

import com.vassbassapp.model.Bandergus;

import java.util.HashMap;
import java.util.Map;

public class BandergusBiolab {
    private static volatile BandergusBiolab instance;
    private BandergusBiolab() {
        this.biolab = new HashMap<>();
    }
    public static BandergusBiolab getInstance() {
        if (instance == null) {
            synchronized (BandergusBiolab.class) {
                if (instance == null) {
                    instance = new BandergusBiolab();
                }
            }
        }
        return instance;
    }

    Map<Long, Bandergus> biolab;

    public Bandergus getBandergus(Long chatId) {
        return biolab.get(chatId);
    }

    public Bandergus createBanderogus(Long chatId) {
        Bandergus bandergus = new Bandergus(chatId);
        biolab.put(chatId, bandergus);
        return bandergus;
    }
}
