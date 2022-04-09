package com.monstersaku.util;

/**
 * Stats.java
 * Kelas Stats memodelkan status yang dimiliki oleh pokemon.
 * @author 18220031 Muhammad Raihan Aulia
 */

import java.lang.System;

public class Stats {
    protected double healthPoint;
    protected double maxHP;
    protected double attack;
    protected double defense;
    protected double specialAttack;
    protected double specialDefense;
    protected double speed;
    protected StatBuff statBuff;

    /**
     * Constructor
     * @param healthPoint
     * @param attack
     * @param defense
     * @param specialAttack
     * @param specialDefense
     * @param speed
     */
    public Stats(double healthPoint, double attack, double defense, double specialAttack, double specialDefense, double speed){
        this.maxHP = healthPoint;
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.statBuff = new StatBuff();
    }
    /**
     * Stat buff cloner constructor
     * @param stat
     */
    public Stats(Stats stat){
        this.maxHP = stat.maxHP;
        this.healthPoint = stat.healthPoint;
        this.attack = stat.attack;
        this.defense = stat.defense;
        this.specialAttack = stat.specialAttack;
        this.specialDefense = stat.specialDefense;
        this.speed = stat.speed;
        this.statBuff = new StatBuff();
    }

    // Getter
    public StatBuff getStatBuff(){
        return statBuff;
    }
    public double getHP(){
        return healthPoint;
    }
    public double getMaxHP(){
        return maxHP;
    }
    public double getAttack(){
        int buffFactor = statBuff.getBuffAttack();
        if(buffFactor < 0){
            return attack*2/(2-buffFactor);
        }
        else if(buffFactor == 0){
            return attack;
        }
        else{
            return attack*(2+buffFactor)/2;
        }
    }
    public double getDefense(){
        int buffFactor = statBuff.getBuffDefense();
        if(buffFactor < 0){
            return defense*2/(2-buffFactor);
        }
        else if(buffFactor == 0){
            return defense;
        }
        else{
            return defense*(2+buffFactor)/2;
        }
    }
    public double getSpecialAttack(){
        int buffFactor = statBuff.getBuffSpecialAttack();
        if(buffFactor < 0){
            return specialAttack*2/(2-buffFactor);
        }
        else if(buffFactor == 0){
            return specialAttack;
        }
        else{
            return specialAttack*(2+buffFactor)/2;
        }
    }

    public double getSpecialDefense(){
        int buffFactor = statBuff.getBuffSpecialDefense();
        if(buffFactor < 0){
            return specialDefense*2/(2-buffFactor);
        }
        else if(buffFactor == 0){
            return specialDefense;
        }
        else{
            return specialDefense*(2+buffFactor)/2;
        }
    }

    public double getSpeed(int condition){
        int buffFactor = statBuff.getBuffSpeed();
        double currSpeed = speed;
        if(buffFactor < 0){
            currSpeed *= 2/(2-buffFactor);
        }
        else if(buffFactor > 0){
            currSpeed *= (2+buffFactor)/2;
        }
        if(condition == 4){
            return currSpeed*0.5;
        }
        else{
            return currSpeed;
        }
    }

    // Setter
    public void setHP(double hp){
        this.healthPoint = hp;
    }
    public void setAttack(double attack){
        this.attack = attack;
    }
    public void setDefense(double defense){
        this.defense = defense;
    }
    public void setSpecialAttack(double specialAttack){
        this.specialAttack = specialAttack;
    }
    public void setSpecialDefense(double specialDefense){
        this.specialDefense = specialDefense;
    }
    public void setSpeed(double speed){
        this.speed = speed;
    }
    public void setStatBuff(StatBuff statBuff){
        this.statBuff = statBuff;
    }

    // Method
    public void printStats(int condition){
        System.out.println("Stats :");
        System.out.print("Health Point      : ");
        System.out.println(getHP());
        System.out.print("Attack            : ");
        System.out.println(getAttack());
        System.out.print("Defense           : ");
        System.out.println(getDefense());
        System.out.print("Special Attack    : ");
        System.out.println(getSpecialAttack());
        System.out.print("Special Defense   : ");
        System.out.println(getSpecialDefense());
        System.out.print("Speed             : ");
        System.out.println(getSpeed(condition));
    }
}
