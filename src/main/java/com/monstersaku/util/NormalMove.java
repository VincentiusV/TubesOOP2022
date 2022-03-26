package com.monstersaku.util;

public class NormalMove extends Move {
    protected int id;
    protected String name;
    protected ElementType elementType;
    protected int accuracy;
    protected int priority;
    protected int ammunition;
    
    public NormalMove(String name, ElementType elementType, int accuracy, int priority, int ammunition){
        super(name, elementType, accuracy, priority,ammunition);
    }

    public void useNormalMove (Monster monster1, Monster monster2){
        
    }

}
