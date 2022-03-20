/**
 * Stats.java
 * Kelas Stats memodelkan status yang dimiliki oleh pokemon.
 * @author 18220031 Muhammad Raihan Aulia
 */

public class Stats {
    private double healthPoint;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;

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

    }
    


    // Getter
    public double getHP(){
        return healthPoint;
    }
    public double getAttack(){
        return attack;
    }
    public double getDefense(){
        return defense;
    }
    public double getSpecialAttack(){
        return specialAttack;
    }
    public double getSpecialDefense(){
        return specialDefense;
    }
    public double getSpeed(){
        return speed;
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

}
