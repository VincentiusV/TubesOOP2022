package com.monstersaku.util;

public class NormalMove extends Move {
    protected int id;
    protected String name;
    protected ElementType elementType;
    protected int accuracy;
    protected int priority;
    protected int ammunition;
    
    public NormalMove(String name, ElementType elementType, int accuracy, int priority, int ammunition,  String target){
        super(name, elementType, accuracy, priority,ammunition, target);
    }

    public Monster useMove (Monster sourceMonster, Monster targetMonster){
        float finaldamage= (float)Math.floor((((sourceMonster.getBaseStats().getAttack()) / (targetMonster.getBaseStats().getDefense())) + 2 ) * Math.floor(Math.random()*(1-0.85+1)+0.85) * getEffectivity(this, targetMonster));
        Double HPBaru;
        HPBaru = targetMonster.getBaseStats().getHP() - finaldamage;
        targetMonster.getBaseStats().setHP(HPBaru);
        ammunition -= 1;

        return targetMonster;
    }
}