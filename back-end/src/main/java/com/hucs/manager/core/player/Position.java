package com.hucs.manager.core.player;

public enum Position {

    GKP("Goal keeper"),
    DEF("Deffensive"),
    MID("Mid field"),
    ATT("Attack");

    private final String description;

    Position(String description){
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

}
