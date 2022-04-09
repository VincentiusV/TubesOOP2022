package com.monstersaku.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Monster {
    protected String name;
    protected List<ElementType> elementTypeList;
    protected Stats baseStats;
    private List<Move> moveList;
    private ArrayList<Integer> condition;
    // condition[0] berisi integer yang menandakan effect saat ini. Jika bernilai 0, artinya tidak dalam kondisi abnormal.
    // condition[0] = 1. Burn 2. Poison 3. Sleep 4. Paralyze
    // condition[1] berisi integer yang menandakan kapan kondisi akan berhenti. Jika bernilai -1, artinya effect tidak akan hilang

    public Monster(String name, List<ElementType> elementTypeList, Stats baseStats, List<Move> moveList) {
        this.name = name;
        this.elementTypeList = elementTypeList;
        this.baseStats = baseStats;
        this.moveList = moveList;
        this.condition = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            condition.add(0);
        }
    }

    // clone consstructor
    public Monster(Monster monster){
        List<Move> monsterMove = monster.getMoveList();
        List<Move> newMoveList = new LinkedList<Move>();
        Move newmove;
        for(Move move : monsterMove){
            if (move.getClass().getSimpleName().equals("StatusMove")) {
                StatusMove statusMove = (StatusMove) move;
                newmove = new StatusMove(statusMove);
            } else if (move.getClass().getSimpleName().equals("NormalMove")) {
                NormalMove normalMove = (NormalMove) move;
                newmove = new NormalMove(normalMove);
            } else {
                SpecialMove specialMove = (SpecialMove) move;
                newmove = new SpecialMove(specialMove);
            }
            newMoveList.add(newmove);
        }
        this.name = monster.name;
        this.elementTypeList = monster.elementTypeList;
        this.baseStats = monster.baseStats;
        this.moveList = newMoveList;
        this.condition = monster.getCondition();
    }

    public String getName() {
        return name;
    }

    public List<ElementType> getElementTypeList() {
        return elementTypeList;
    }

    public ElementType getElementType(int i) {
        return elementTypeList.get(i);
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    /**
     * Mengembalikan condition dalam bentuk array.
     * condition.get(0) untuk mendapatkan tipe kondisi abnormal
     *  1. Burn 2. Poison 3. Sleep 4. Paralyze
     * condition.get(1) untuk mendapatkan lama kondisi bertahan
     * @return condition
     */
    public ArrayList<Integer> getCondition() {
        return condition;
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
    

    /**
     * Mengubah atribute condition.
     * @param condition_type
     * @param turn
     */
    public void setconditionList(int condition_type, int turn) {
        condition.set(0, condition_type);
        condition.set(1, turn);
    }

    // numpang print monster move
    public void printMonsterMoves() {
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

    

    public boolean isDead() {
        return (getBaseStats().getHP() <= 0);
    }
}
