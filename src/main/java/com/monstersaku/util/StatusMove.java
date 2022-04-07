package com.monstersaku.util;

public class StatusMove extends Move{
    private int id;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    private String statusCondition;

    public StatusMove(String name, ElementType elementType, int accuracy, int priority, int ammunition, String statusCondition, String target){
        super(name, elementType, accuracy, priority, ammunition, target);
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
                break;
        }
        return targetMonster;
    }
}