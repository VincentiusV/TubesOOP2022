package com.monstersaku.util;

import java.util.ArrayList;
import java.util.List;

public class Monster {
    protected String name;
    protected List<ElementType> elementTypeList;
    protected Stats baseStats;
    private List<Move> moveList;
    private ArrayList<Boolean> conditionList;

    public Monster(String name, List<ElementType> elementTypeList, Stats baseStats, List<Move> moveList,List<Boolean> conditionList) {
        this.name = name;
        this.elementTypeList = elementTypeList;
        this.baseStats = baseStats;
        this.moveList = moveList;
        this.conditionList = new ArrayList<Boolean>();
        for (int i = 0; i < 4; i++) {
            conditionList.add(false); //0. Burn 1. Poison 2. Sleep 3. Paralyze
        }
        
        
    }
    
        public Monster(String name, List<ElementType> elementTypeList, Stats baseStats) {
            this.name = name;
            this.elementTypeList = elementTypeList;
            this.baseStats = baseStats;
        }      
            ;


    public String getName() {
        return name;
    }

    public List<ElementType> getElementTypeList() {
        return elementTypeList;
    }

    public ElementType getElementType(int i){
        return elementTypeList.get(i);
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public List<Move> getMoveList() {
        return moveList;
    }
    public Boolean getconditionList(int i){
        return conditionList.get(i);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setElementTypeList(List<ElementType> elementTypeList) {
        this.elementTypeList = elementTypeList;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

    public void setMoveList(List<Move> moveList) {
        this.moveList = moveList;
    }

    public void setconditionList(int i, boolean state){
        conditionList.set(i, state);
    }

    // numpang print monster move
    public void printMonsterMoves(){
        System.out.println("}=== MOVE LIST ========================{");
        for (Move move : moveList) {
            System.out.println();
            String name = move.getName();
            ElementType elementType = move.getElementType();

            
            System.out.print(String.format("%d.%s ", moveList.indexOf(move), name));
            System.out.print("=".repeat(26 - name.length()));
            System.out.println("{");

            // print ElementType
            System.out.print("Element Types : ");
            if (elementType == ElementType.NORMAL) {
                System.out.println("NORMAL");
            } else if (elementType == ElementType.FIRE) {
                System.out.println("FIRE");
            } else if (elementType == ElementType.WATER) {
                System.out.println("WATER");
            } else if (elementType == ElementType.GRASS) {
                System.out.println("GRASS");
            }

            // print classType
            System.out.print("Move type     : ");
            if (move instanceof NormalMove) {
                System.out.println("NORMAL MOVE");
            } else if (move instanceof SpecialMove) {
                System.out.println("SPECIAL MOVE");
            } else if (move instanceof StatusMove) {
                System.out.println("STATUS MOVE");
            }

            // print Stats of move
            System.out.println("Accuracy      : " + move.getAccuracy());
            System.out.println("Priority      : " + move.getPriority());
            System.out.println("Ammunition    : " + move.getAmmunition());
        }
    }
    

    // Coba-coba aja
    public void fight(Monster monster){
        if (this.getBaseStats().getAttack() > monster.getBaseStats().getDefense()){
            if (this.getBaseStats().getAttack()-monster.getBaseStats().getHP() >= 0){
                Stats newStats = new Stats(monster.getBaseStats().getHP() - (this.getBaseStats().getAttack()-monster.getBaseStats().getDefense()),
                        monster.getBaseStats().getAttack(), monster.getBaseStats().getDefense(),
                        monster.getBaseStats().getSpecialAttack(), monster.getBaseStats().getSpecialDefense(),
                        monster.getBaseStats().getSpeed());
                monster.setBaseStats(newStats);
            }
            else{
                Stats newStats = new Stats(0,
                        monster.getBaseStats().getAttack(), monster.getBaseStats().getDefense(),
                        monster.getBaseStats().getSpecialAttack(), monster.getBaseStats().getSpecialDefense(),
                        monster.getBaseStats().getSpeed());
                monster.setBaseStats(newStats);
            }
        }
        else{
            System.out.println(this.getName()+" gagal menyerang "+monster.getName());
        }
    }
    public boolean isDead() {
        return (getBaseStats().getHP() <= 0);
    }
}
