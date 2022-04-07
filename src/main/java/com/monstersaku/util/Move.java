package com.monstersaku.util;

import java.util.List;
import java.util.ArrayList;

public abstract class Move{
    protected int id;
    protected String name;
    protected ElementType elementType;
    protected int accuracy;
    protected int priority;
    protected int ammunition;
    protected String target;

    //konstruktor
    public Move(String name, ElementType elementType, int accuracy, int priority, int ammunition, String target){
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    }
    
    //getter & setter
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ElementType getElementType() {
        return this.elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getAmmunition() {
        return this.ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public Double getEffectivity(Move move, Monster targetMonster){
        Double effectivityFinal = 1.0;
        ElementEffectivity eleEff = new ElementEffectivity();

        for (int i=0 ; i < targetMonster.elementTypeList.size(); i++){
            if ((this.getElementType() == ElementType.FIRE) && (targetMonster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= eleEff.fireFire;
            }
            else if ((this.getElementType() == ElementType.FIRE) && (targetMonster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= eleEff.fireWater;
            }
            else if ((this.getElementType() == ElementType.FIRE) && (targetMonster.getElementType(i) == ElementType.GRASS)){
                effectivityFinal *= eleEff.fireGrass;
            }
            else if ((this.getElementType() == ElementType.FIRE) && (targetMonster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= eleEff.fireNormal;
            }
            else if ((this.getElementType() == ElementType.WATER) && (targetMonster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= eleEff.waterFire;
            }
            else if ((this.getElementType() == ElementType.WATER) && (targetMonster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= eleEff.waterWater;
            }
            else if ((this.getElementType() == ElementType.WATER) && (targetMonster.getElementType(i) == ElementType.GRASS)){
                effectivityFinal *= eleEff.waterGrass;
            }
            else if ((this.getElementType() == ElementType.WATER) && (targetMonster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= eleEff.waterNormal;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (targetMonster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= eleEff.grassFire;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (targetMonster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= eleEff.grassWater;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (targetMonster.getElementType(i)) == ElementType.GRASS){
                effectivityFinal *= eleEff.grassGrass;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (targetMonster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= eleEff.grassNormal;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (targetMonster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= eleEff.normalFire;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (targetMonster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= eleEff.normalWater;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (targetMonster.getElementType(i) == ElementType.GRASS)){
                effectivityFinal *= eleEff.normalGrass;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (targetMonster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= eleEff.normalNormal;
            }
            else{
                effectivityFinal *= 1;
            }
        }
        return effectivityFinal;
    }
    public abstract Monster useMove (Monster sourceMonster, Monster targetMonster);
}