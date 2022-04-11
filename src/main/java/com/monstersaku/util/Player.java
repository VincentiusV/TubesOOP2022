package com.monstersaku.util;

import java.util.List;

public class Player {
    private String playerName;
    private List<Monster> monsterList;
    private int countMonster;
    private int currentMonsterIndex = -1;

    public Player(String playerName, List<Monster> monsterList) {
        this.playerName = playerName;
        this.monsterList = monsterList;
        countMonster = 6;
    }

    public String getPlayerName() {
        return playerName;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public int getCountMonster() {
        return countMonster;
    }

    public int getCurrentMonsterIndex() {
        return currentMonsterIndex;
    }

    public void setCurrentMonsterIndex(int newMonsterIndex) {
        this.currentMonsterIndex = newMonsterIndex;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public void printMonsterList() {
        int index = 0;
        System.out.println("=== === " + getPlayerName().toUpperCase() + " MONSTER === ===");
        for (Monster monster : monsterList) {
            String name = monster.getName();
            List<ElementType> elementTypes = monster.getElementTypeList();
            Stats stat = monster.getBaseStats();

            // print Monster Name
            System.out.printf("%d.%s ", index, name);
            System.out.print("=".repeat(30-name.length()));
            System.out.print(">");
            if (index == currentMonsterIndex) {
                System.out.println(" <CURRENTLY USED> ");
            } else {
                System.out.println();
            }

            // print ElementType
            System.out.print("Element Types     : ");
            for (ElementType elementType : elementTypes) {
                if (elementType == ElementType.NORMAL) {
                    System.out.print("NORMAL ");
                } else if (elementType == ElementType.FIRE) {
                    System.out.print("FIRE ");
                } else if (elementType == ElementType.WATER) {
                    System.out.print("WATER ");
                } else if (elementType == ElementType.GRASS) {
                    System.out.print("GRASS ");
                }
            }
            System.out.println();
            stat.printStats(0);
            monster.printCondition();
            index += 1;
        }
    }

    public void monsterDead(Monster monster) {
        if (monster.getBaseStats().getHP() <= 0) {
            monsterList.remove(currentMonsterIndex);
            currentMonsterIndex = -1;
            countMonster -= 1;
        }
    }

    public boolean isHaveMonster() {
        return monsterList.size() != 0;
    }
}
