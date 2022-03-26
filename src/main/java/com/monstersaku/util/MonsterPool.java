package com.monstersaku.util;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * MonsterPool is a pool of monster based on monsterpool.csv file.
 * To get the list of monster, use method "getPool()".
 * @author Muhammad Raihan Aulia 18220031
 */
public class MonsterPool {
    // idMove menjadi nomor di array
    private static String file_path = "../configs/monsterpool.csv";
    private List<Monster> pool = new LinkedList<Monster>();
    private MovePool movePool = new MovePool();
    private List<Move> movelist = movePool.getPool();
    
    /**
     * Creating a MonsterPool object.
     * if and exception occured, outputs a warning.
     * @return MonsterPool object.
     */
    public MonsterPool(){
        try {
            CSVReader reader = new CSVReader(new File(MonsterPool.class.getResource(file_path).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                Monster monster = stringtoMonster(line);
                pool.add(monster);

            }
        } catch (Exception e) {
          System.out.println("Maafkan saya, saya tidak dapat membaca \"monsterpool.csv\"");
        }
    }
    /**
     * Getter of Pool (list of monster) from MonsterPool class
     * @return list of monster
     */
    public List<Monster> getPool(){
        return pool;
    }
    /**
     * Getter of movePool (an object of MovePool)
     * @return movePool
     */
    public MovePool getMovePool(){
        return movePool;
    }

    /**
     * Turn an array of string to acceptable format to make a object of Monster
     * @param input in form of array of string
     * @return Monster object
     */
    private Monster stringtoMonster(String[] input){
        String name = input[1];
        List<ElementType> elementTypeList = stringtoListElementTypes(input[2]);
        Stats baseStats = stringtoStats(input[3]);
        List<Move> movepool = moveCompare(input[4]);
        

        Monster monster = new Monster(name, elementTypeList, baseStats, movepool);
        return monster;
    }
    /**
     * Turn string to acceptable format to make a list of element types
     * @param input in form of string
     * @return list object of element type
     */
    private List<ElementType> stringtoListElementTypes(String input){
        String arrString[] = input.split(",");
        List<ElementType> list = new LinkedList<ElementType>();
        for(String elementType : arrString){
            if(elementType.equals("NORMAL")){
                list.add(ElementType.NORMAL);
            }
            else if(elementType.equals("FIRE")){
                list.add(ElementType.FIRE);
            }
            else if(elementType.equals("WATER")){
                list.add(ElementType.WATER);
            }
            else if(elementType.equals("GRASS")){
                list.add(ElementType.GRASS);
            }
        }
        return list;
    }
    /**
     * Turn string to acceptable format to make a Stats object.
     * @param input in form of string
     * @return Stats object.
     */
    private Stats stringtoStats(String input){
        String arrString[] = input.split(",");
        double healthPoint = Double.parseDouble(arrString[0]);
        double attack = Double.parseDouble(arrString[1]);
        double defense = Double.parseDouble(arrString[2]);
        double specialAttack = Double.parseDouble(arrString[3]);
        double specialDefense = Double.parseDouble(arrString[4]);
        double speed = Double.parseDouble(arrString[5]);



        Stats bStats = new Stats(healthPoint, attack, defense, specialAttack, specialDefense, speed);
        return bStats;
    }
    /**
     * Comparing the moves in monsterpool.csv with MovePool
     * @return List of move. List representing Monster's move
     */
    private List<Move> moveCompare(String input){
        String[] arrString = input.split(",");
        List<Move> monsterMove = new LinkedList<Move>();

        for(String idString : arrString){
            int id = Integer.parseInt(idString);
            Move move = movelist.get(id-1);
            monsterMove.add(move);
        }
        return monsterMove;
    }

    /**
     * Print every monster in the movepool with their ElementType, Stats, and
     * Move included.
     */
    public void printMonsterPool(){
        System.out.println("}=== MONSTEDEX ========================{");
        for(Monster monster : pool){
            String name = monster.getName();
            List<ElementType> elementTypes = monster.getElementTypeList();
            Stats stat = monster.getBaseStats();

            // print Monster Name
            System.out.print(String.format("%s ", name));
            System.out.print("=".repeat(30-name.length()));
            System.out.println(">");

            // print ElementType
            System.out.print("Element Types : ");
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
            // print Monster Stats
            stat.printStats();

            // print Move set Monster
            System.out.println("MOVE SET : ");
            for(Move move : monster.getMoveList()){
                System.out.println(move.getName());
            }
            System.out.println();
        }
    }
}