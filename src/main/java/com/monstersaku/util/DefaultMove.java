package com.monstersaku.util;


public class DefaultMove extends Move {

    // Constructor
    public DefaultMove() {
        super("DEFAULT", ElementType.NORMAL, 100, 0, -1, "ENEMY");
    }

    // clone constructor
    public DefaultMove(DefaultMove move) {
        super(move.name, move.elementType, move.accuracy, move.priority, move.ammunition, move.target);
    }

    public void useMove(Monster monster1, Monster monster2, int turn) {
        Monster sourceMonster;
        Monster targetMonster;
        float finaldamage;
        if(super.getTarget().equals("OWN")){
            targetMonster = monster1;
            sourceMonster = monster1;
        }
        else{
            targetMonster = monster2;
            sourceMonster = monster1;
        }
        if(sourceMonster.getCondition().get(0) == 1){ // monster kondisi BURN
            finaldamage = (float) Math
                .floor((((sourceMonster.getBaseStats().getAttack()) / (targetMonster.getBaseStats().getDefense())) + 2)
                        * Math.floor(Math.random() * (1 - 0.85 + 1) + 0.85) * getEffectivity(this, targetMonster) * 0.5);
        }
        else{
            finaldamage = (float) Math
                .floor((((sourceMonster.getBaseStats().getAttack()) / (targetMonster.getBaseStats().getDefense())) + 2)
                        * Math.floor(Math.random() * (1 - 0.85 + 1) + 0.85) * getEffectivity(this, targetMonster));
        }
        // Target
        Double hpBaruTarget;
        hpBaruTarget = targetMonster.getBaseStats().getHP() - finaldamage;
        targetMonster.getBaseStats().setHP(hpBaruTarget);
        String targetName = targetMonster.getName();
        System.out.printf("%s menggunakan move %s kepada %s! %s mendapatkan damage sebesar %.2f.%n",
                sourceMonster.getName(), super.name, targetName, targetName, finaldamage);
        // Source
        Stats sourceStats = sourceMonster.getBaseStats();
        Double hpBaruSource = sourceStats.getHP() - Math.floor(sourceStats.getMaxHP()/4);
        sourceMonster.getBaseStats().setHP(hpBaruSource);
        System.out.printf("%s mendapatkan damage sebesar %.2f karena penggunaan move %s.%n", sourceMonster.getName(), Math.floor(sourceStats.getMaxHP()/4), super.name);
    }
}