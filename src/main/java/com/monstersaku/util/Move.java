package com.monstersaku.util;

import java.util.List;
import java.util.ArrayList;

public class Move{
    protected int id;
    protected String name;
    protected ElementType elementType;
    protected int accuracy;
    protected int priority;
    protected int ammunition;

    //konstruktor
    public Move(String name, ElementType elementType, int accuracy, int priority, int ammunition){
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

    public Double getEffectivity(Move move, Monster monster){
        Double effectivityFinal = 1.0;

        for (int i=0 ; i < monster.elementTypeList.size(); i++){
            if ((this.getElementType() == ElementType.FIRE) && (monster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= 0.25;
            }
            else if ((this.getElementType() == ElementType.FIRE) && (monster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= 0.9;
            }
            else if ((this.getElementType() == ElementType.FIRE) && (monster.getElementType(i) == ElementType.GRASS)){
                effectivityFinal *= 1.5;
            }
            else if ((this.getElementType() == ElementType.FIRE) && (monster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= 1.5;
            }
            else if ((this.getElementType() == ElementType.WATER) && (monster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.WATER) && (monster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= 0.25;
            }
            else if ((this.getElementType() == ElementType.WATER) && (monster.getElementType(i) == ElementType.GRASS)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.WATER) && (monster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (monster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (monster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= 1.75;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (monster.getElementType(i)) == ElementType.GRASS){
                effectivityFinal *= 0.25;
            }
            else if ((this.getElementType() == ElementType.GRASS) && (monster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (monster.getElementType(i) == ElementType.FIRE)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (monster.getElementType(i) == ElementType.WATER)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (monster.getElementType(i) == ElementType.GRASS)){
                effectivityFinal *= 1;
            }
            else if ((this.getElementType() == ElementType.NORMAL) && (monster.getElementType(i) == ElementType.NORMAL)){
                effectivityFinal *= 1;
            }
            else{
                effectivityFinal *= 1;
            }
        }
        return effectivityFinal;
    }
}