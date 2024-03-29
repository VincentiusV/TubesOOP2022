package com.monstersaku.util;

public class StatusMove extends Move{
    private Stats changedStats;
    private String statusCondition;

    public StatusMove(String name, ElementType elementType, int accuracy, int priority, int ammunition, String statusCondition, Stats changedStats, String target){
        super(name, elementType, accuracy, priority, ammunition, target);
        this.changedStats = changedStats;
        this.statusCondition = statusCondition;
    }
    // Clone Constructor
    public StatusMove(StatusMove move){
        super(move.name, move.elementType, move.accuracy, move.priority, move.ammunition, move.target);
        this.changedStats = move.changedStats;
        this.statusCondition = move.statusCondition;
    }
    
    public String getStatusCondition(){
        return statusCondition;
    }

    public Stats getChangedStats(){
        return changedStats;
    }
    public void useMove(Monster monster1, Monster monster2, int turn) {
        Monster sourceMonster;
        Monster targetMonster;
        if(super.getTarget().equals("OWN")){
            targetMonster = monster1;
            sourceMonster = monster1;
        }
        else{
            targetMonster = monster2;
            sourceMonster = monster1;
        }
        System.out.printf("%s menggunakan move %s kepada %s! ", sourceMonster.getName(), name, targetMonster.getName());
        switch (statusCondition) {
            case "BURN": // BURN
                System.out.printf("%s Mendapatkan status BURN!!! %n", targetMonster.getName());
                targetMonster.setconditionList(1,-1);
                break;
            case "POISON": // POISON
                System.out.printf("%s Mendapatkan status POISON!!! %n", targetMonster.getName());
                targetMonster.setconditionList(2,-1);
                break;
            case "SLEEP": // SLEEP
                System.out.printf("%s Mendapatkan status SLEEP!!! %n", targetMonster.getName());
                System.out.printf("%s mendengkur dengan cukup kuat...%n", targetMonster.getName());
                int ended = turn + 1 + (int)(Math.random() * 6 + 1);
                targetMonster.setconditionList(3, ended);
                break;
            case "PARALYZE": // PARALYZE
                System.out.printf("%s Mendapatkan status PARALYZE!!! %n", targetMonster.getName());
                targetMonster.setconditionList(4,-1);
                break;
            default:
            targetMonster.setBaseStats(buffDebuff(targetMonster.getBaseStats(), changedStats));
            System.out.println();
            break;
        }
        super.ammunition -= 1;
    }
    public Stats buffDebuff(Stats currStats, Stats affectingStats){
        double hp = currStats.getHP() + affectingStats.getHP();
        currStats.setHP(Double.min(currStats.getMaxHP(), hp));
        
        StatBuff statBuff = currStats.getStatBuff();
        statBuff.setBuffAttack(affectingStats.getAttack());
        statBuff.setBuffDefense(affectingStats.getDefense());
        statBuff.setBuffSpecialAttack(affectingStats.getSpecialAttack());
        statBuff.setBuffSpecialAttack(affectingStats.getSpecialDefense());
        statBuff.setBuffSpeed(affectingStats.getSpeed(0));
        currStats.setStatBuff(statBuff);
        return currStats;
    }

}