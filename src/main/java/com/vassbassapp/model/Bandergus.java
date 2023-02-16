package com.vassbassapp.model;

public class Bandergus {
    private Long id;
    private int level = 1;

    public Bandergus(Long id) {
        this.id = id;
    }

    public void levelUp() {
        level++;
    }

    public int getLevel() {
        return level;
    }
}
