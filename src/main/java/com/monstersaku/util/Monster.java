package com.monstersaku.util;

import java.util.List;

public class Monster {
    private String name;
    private List<ElementType> elementTypeList;
    private Stats baseStats;
    private List<Move> moveList;

    public Monster(String name, List<ElementType> elementTypeList, Stats baseStats, List<Move> moveList) {
        this.name = name;
        this.elementTypeList = elementTypeList;
        this.baseStats = baseStats;
        this.moveList = moveList;
    }

    public String getName() {
        return name;
    }

    public List<ElementType> getElementTypeList() {
        return elementTypeList;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public List<Move> getMoveList() {
        return moveList;
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

    // Coba-coba aja
    public void fight(Monster monster){
        if (this.getBaseStats().getAttack() > monster.getBaseStats().getDefense()){
            Stats newStats = new Stats(this.getBaseStats().getAttack()-monster.getBaseStats().getHP(),
                                        monster.getBaseStats().getAttack(), monster.getBaseStats().getDefense(),
                                        monster.getBaseStats().getSpecialAttack(), monster.getBaseStats().getSpecialDefense(),
                                        monster.getBaseStats().getSpeed());
            monster.setBaseStats(newStats);
        }
    }
}
