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
}

