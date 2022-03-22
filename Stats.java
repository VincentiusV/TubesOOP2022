/**
 * Stats.java
 * Kelas Stats memodelkan status yang dimiliki oleh pokemon.
 * @author 18220031 Muhammad Raihan Aulia
 */

import java.lang.System;

public class Stats {
    private double healthPoint;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;
    private StatBuff statBuff;

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
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.statBuff = new StatBuff();
    }
    

    // Getter
    public StatBuff getStatBuff(){
        return statBuff;
    }
    public double getHP(){
        return healthPoint;
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

    public double getSpeed(){
        int buffFactor = statBuff.getBuffSpeed();
        if(buffFactor < 0){
            return speed*2/(2-buffFactor);
        }
        else if(buffFactor == 0){
            return speed;
        }
        else{
            return speed*(2+buffFactor)/2;
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
    public void printStats(){
        System.out.print("Stats :");
        System.out.print("Health Point      : ");
        System.out.println(healthPoint);
        System.out.print("Attack            : ");
        System.out.println(attack);
        System.out.print("Defense           : ");
        System.out.println(defense);
        System.out.print("Special Attack    : ");
        System.out.println(specialAttack);
        System.out.print("Special Defense   : ");
        System.out.println(specialDefense);
        System.out.print("Speed             : ");
        System.out.println(speed);
    }
}
