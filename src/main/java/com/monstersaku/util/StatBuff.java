package com.monstersaku.util;

public class StatBuff {
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    // Constructor
    StatBuff(){
        attack = 0;
        defense = 0;
        specialAttack = 0;
        specialDefense = 0;
        speed = 0;
    }

    // Getter
    public int getBuffAttack(){
        return attack;
    }
    public int getBuffDefense(){
        return defense;
    }
    public int getBuffSpecialAttack(){
        return specialAttack;
    }
    public int getBuffSpecialDefense(){
        return specialDefense;
    }
    public int getBuffSpeed(){
        return speed;
    }

    // Setter
    public void setBuffAttack(double times){
        attack += times;
        if(attack < -4){
            attack = -4;
        }
        else if(attack > 4){
            attack = 4;
        }
    }
    public void setBuffDefense(double times){
        defense += times;
        if(defense < -4){
            defense = -4;
        }
        else if(defense > 4){
            defense = 4;
        }    
    }
    public void setBuffSpecialAttack(double times){
        specialAttack += times;
        if(specialAttack < -4){
            specialAttack = -4;
        }
        else if(specialAttack > 4){
            specialAttack = 4;
        }    
    }
    public void setBuffSpecialDefense(double times){
        specialDefense += times;
        if(specialDefense < -4){
            specialDefense = -4;
        }
        else if(specialDefense > 4){
            specialDefense = 4;
        }    
    }
    public void setBuffSpeed(double times){
        speed += times;
        if(speed < -4){
            speed = -4;
        }
        else if(speed > 4){
            speed = 4;
        }
    }

    
    // Method
    public void resetBuff(){
        attack = 0;
        defense = 0;
        specialAttack = 0;
        specialDefense = 0;
        speed = 0;
    }

    public void printBuff(){
        System.out.println("Buff & Debuff: ");
        if(attack != 0){
            System.out.printf("Attack %d ", attack);
        }
        if(defense != 0){
            System.out.printf("Defense %d ", defense);
        }
        if(specialAttack != 0){
            System.out.printf("Special Attack %d ", specialAttack);
        }
        if(specialDefense != 0){
            System.out.printf("Special Defense %d ", specialDefense);
        }
        if(speed != 0){
            System.out.printf("Speed %d ", speed);
        }
        System.out.println();
    }
}
