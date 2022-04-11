package com.monstersaku.util;

public class NormalMove extends Move {

    // Constructor
    public NormalMove(String name, ElementType elementType, int accuracy, int priority, int ammunition, String target) {
        super(name, elementType, accuracy, priority, ammunition, target);
    }

    // clone constructor
    public NormalMove(NormalMove move) {
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
        Double HPBaru;
        HPBaru = targetMonster.getBaseStats().getHP() - finaldamage;
        targetMonster.getBaseStats().setHP(HPBaru);
        super.ammunition -= 1;
        String targetName = targetMonster.getName();
        System.out.printf("%s menggunakan move %s kepada %s! %s mendapatkan damage sebesar %.2f.%n",
                sourceMonster.getName(), super.name, targetName, targetName, finaldamage);
    }
}