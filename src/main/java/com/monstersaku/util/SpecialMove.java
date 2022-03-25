package com.monstersaku.util;

public class SpecialMove extends Move{
    protected int id;
    protected String name;
    protected ElementType elementType;
    protected int accuracy;
    protected int priority;
    protected int ammunition;
    
    public SpecialMove(String name, ElementType elementType, int accuracy, int priority, int ammunition){
        super(name, elementType, accuracy, priority,ammunition);
    }
}
