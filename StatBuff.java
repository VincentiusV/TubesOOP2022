import java.lang.System;

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
    public void setBuffAttack(int times){
        attack = times;
    }
    public void setBuffDefense(int times){
        defense = times;
    }
    public void setBuffSpecialAttack(int times){
        specialAttack = times;
    }
    public void setBuffSpecialDefense(int times){
        specialDefense = times;
    }
    public void setBuffSpeed(int times){
        speed = times;
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
            System.out.println(String.format("Attack %d", attack));
        }
        if(defense != 0){
            System.out.println(String.format("Defense %d", defense));
        }
        if(specialAttack != 0){
            System.out.println(String.format("Special Attack %d", specialAttack));
        }
        if(specialDefense != 0){
            System.out.println(String.format("Special Defense %d", specialDefense));
        }
        if(speed != 0){
            System.out.println(String.format("Speed %d", speed));
        }
    }
}
