package com.hucs.manager.core.task;

public enum TaskStatus {

    OPEN("Aberta"),IN_PROGRESS("Em andamento"), CLOSED("Fechada");

    public final String description;

    TaskStatus(String description){
        this.description = description;
    }

}
