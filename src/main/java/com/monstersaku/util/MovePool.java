package com.monstersaku.util;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * MovePool is a pool of move based on movepool.csv file.
 * To get the list of move, use method "getPool()".
 * @author Muhammad Raihan Aulia 18220031
 */
public class MovePool {
    // idMove menjadi nomor di array
    private static String file_path = "../configs/movepool.csv";
    private List<Move> pool = new LinkedList<Move>();
    
    public MovePool(){
        try {
            CSVReader reader = new CSVReader(new File(MovePool.class.getResource(file_path).toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                String name = line[2];
                ElementType elementType = stringtoElementType(line[3]);
                int accuracy = Integer.parseInt(line[4]);
                int priority = Integer.parseInt(line[5]);
                int ammunition = Integer.parseInt(line[6]);
                String target = line[7];
    
                // if the move type is normal move
                if(line[1].equals("NORMAL")){
                    NormalMove move = new NormalMove(name, elementType, accuracy, priority, ammunition);
                    pool.add(move);
                }
                // if the move type is special move
                else if(line[1].equals("SPECIAL")){
                    SpecialMove move = new SpecialMove(name, elementType, accuracy, priority, ammunition);
                    pool.add(move);
                }
                // If the move type is status move
                else if(line[1].equals("STATUS")){
                    String Condition = line[8];
                    Stats changedStats = stringtoStats(line[9]);

                    StatusMove move = new StatusMove(name, elementType, accuracy, priority, ammunition);
                    pool.add(move);
                }
            }
        } catch (Exception e) {
          // do nothing
          System.out.println("Maafkan saya tapi file movepool.csv tidak dapat dibaca.");
        }
    }

    public List<Move> getPool(){
        return pool;
    }

    private ElementType stringtoElementType(String input){
        ElementType elementType = ElementType.NORMAL;
        if(input.equals("NORMAL")){
            elementType = ElementType.NORMAL;
        }
        else if(input.equals("FIRE")){
            elementType = ElementType.FIRE;
        }
        else if(input.equals("WATER")){
            elementType = ElementType.WATER;
        }
        else if(input.equals("GRASS")){
            elementType = ElementType.GRASS;
        }
        return elementType;
    }
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
    
    public void printMovePool(){
        System.out.println("}=== MODEX ========================{");
        for(Move move : pool){
            System.out.println();
            String name = move.getName();
            ElementType elementType = move.getElementType();

            // print Monster Name
            System.out.print(String.format("%s ", name));
            System.out.print("=".repeat(26-name.length()));
            System.out.println("{");

            // print ElementType
            System.out.print("Element Types : ");
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

            // print classType
            System.out.print("Move type     : ");
            if(move instanceof NormalMove){
                System.out.println("NORMAL MOVE");
            }
            else if(move instanceof SpecialMove){
                System.out.println("SPECIAL MOVE");
            }
            else if(move instanceof StatusMove){
                System.out.println("STATUS MOVE");
            }
            
            // print Stats of move
            System.out.println("Accuracy      : " + move.getAccuracy());
            System.out.println("Priority      : " + move.getPriority());
            System.out.println("Ammunition    : " + move.getAmmunition());
        }
    }
}
