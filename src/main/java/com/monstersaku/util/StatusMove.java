package com.monstersaku.util;

public class StatusMove extends Move{
    private int id;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    public StatusMove(String name, ElementType elementType, int accuracy, int priority, int ammunition){
        super(name, elementType, accuracy, priority, ammunition);
    }
}