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

    public void useNormalMove (Monster sourceMonster, Monster targetMonster){
        float finaldamage= (float)Math.floor((((sourceMonster.getBaseStats().getSpecialAttack()) / (targetMonster.getBaseStats().getSpecialDefense())) + 2 ) * Math.random() * getEffectivity(this, targetMonster));
        Double HPBaru;
        HPBaru = targetMonster.getBaseStats().getHP() - finaldamage;
        targetMonster.getBaseStats().setHP(HPBaru);
    }

}
