package com.monstersaku.util;

public class StatusMove extends Move{
    private int id;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    private Stats changedStats;
    private String statusCondition;

    public StatusMove(String name, ElementType elementType, int accuracy, int priority, int ammunition, String statusCondition, Stats changedStats, String target){
        super(name, elementType, accuracy, priority, ammunition, target);
        this.changedStats = changedStats;
        this.statusCondition = statusCondition;
    }
    public boolean checkStatus(Monster targetMonster){
        int i = 0;
        boolean check = false;
        while (i<3) {
            if (targetMonster.getconditionList(i) == true) {
                check = true;
                break;
            }
        }
        return check;
    }
    public Monster useMove(Monster sourceMonster, Monster targetMonster) {
        switch (statusCondition) {
            case "BURN":
                if (checkStatus(targetMonster) == true) {
                    System.out.println("gabisa ni");
                }
                else{targetMonster.setconditionList(0, true);}
                break;
            case "POISON":
            if (checkStatus(targetMonster) == true) {
                System.out.println("gabisa ni");
            }
            else{targetMonster.setconditionList(1, true);}
                break;
            case "PARALYZE":
            if (checkStatus(targetMonster) == true) {
                System.out.println("gabisa ni");
            }
            else{targetMonster.setconditionList(2, true);}
                break;
            case "SLEEP":
            if (checkStatus(targetMonster) == true) {
                System.out.println("gabisa ni");
            }
            else{targetMonster.setconditionList(3, true);}
                break;
            default:
            targetMonster.setBaseStats(buffDebuff(targetMonster.getBaseStats(), changedStats));
            break;
        }
        ammunition -= 1;
        return targetMonster;
    }
    public Stats buffDebuff(Stats currStats, Stats affectingStats){
        double hp = currStats.getHP() + affectingStats.getHP();
        currStats.setHP(Double.min(currStats.getMaxHP(), hp));
        
        StatBuff statBuff = currStats.getStatBuff();
        statBuff.setBuffAttack(affectingStats.getAttack());
        statBuff.setBuffDefense(affectingStats.getDefense());
        statBuff.setBuffSpecialAttack(affectingStats.getSpecialAttack());
        statBuff.setBuffSpecialAttack(affectingStats.getSpecialDefense());
        statBuff.setBuffSpeed(affectingStats.getSpeed());
        currStats.setStatBuff(statBuff);
        return currStats;
    }

}