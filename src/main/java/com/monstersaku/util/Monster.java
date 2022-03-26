package com.monstersaku.util;

import java.util.List;

public class Monster {
    protected String name;
    protected List<ElementType> elementTypeList;
    protected Stats baseStats;
    private List<Move> moveList;

    public Monster(String name, List<ElementType> elementTypeList, Stats baseStats, List<Move> moveList) {
        this.name = name;
        this.elementTypeList = elementTypeList;
        this.baseStats = baseStats;
        this.moveList = moveList;
    }

    public Monster(String name, List<ElementType> elementTypeList, Stats baseStats) {
        this.name = name;
        this.elementTypeList = elementTypeList;
        this.baseStats = baseStats;
    }

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
    public void isDead() {
        if (getBaseStats().getHP() <= 0) {
            System.out.println("Sayangnya monster " + this.getName() + " sudah mati:(");
        } else {
            System.out.println("Monster " + this.getName() + " memiliki sisa darah sebanyak " + this.getBaseStats().getHP());
        }
    }
}
