package com.monstersaku.util;

import java.util.List;

public class Player {
    private String playerName;
    private List<Monster> monsterList;

    public Player(String playerName, List<Monster> monsterList) {
        this.playerName = playerName;
        this.monsterList = monsterList;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }
    public void printMonsterList(){
        System.out.println("=== === "+getPlayerName().toUpperCase()+" MONSTER === ===");
        for(Monster monster : monsterList){
            String name = monster.getName();
            List<ElementType> elementTypes = monster.getElementTypeList();
            Stats stat = monster.getBaseStats();

            // print Monster Name
            System.out.println(String.format("%s ======================>", name));

            // print ElementType
            System.out.println("Element Types: ");
            for(ElementType elementType : elementTypes){
                if(elementType == ElementType.NORMAL){
                    System.out.println("NORMAL");
                }
                else if(elementType == ElementType.FIRE){
                    System.out.println("FIRE");
                }
                else if(elementType == ElementType.WATER){
                    System.out.println("WATER");
                }
                else if(elementType == ElementType.GRASS){
                    System.out.println("GRASS");
                }
            }
            stat.printStats();
        }
    }
}

