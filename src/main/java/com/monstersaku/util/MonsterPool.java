package com.monstersaku.util;
import java.io.File;
import java.util.LinkedList;
import java.util.List;


public class MonsterPool {
    // idMove menjadi nomor di array
    private String file_path = "../configs/monsterpool.csv";
    private List<Monster> pool = new LinkedList<Monster>();
    
    // Constructor
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
          // do nothing
        }
    }

    public List<Monster> getPool(){
        return pool;
    }

    private Monster stringtoMonster(String[] input){
        String name = input[1];
        List<ElementType> elementTypeList = stringtoListElementTypesList(input[2]);
        Stats baseStats = stringtoStats(input[3]);
        

        Monster monster = new Monster(name, elementTypeList, baseStats);
        return monster;
    }

    private List<ElementType> stringtoListElementTypesList(String input){
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

    public void printMonsterPool(){
        System.out.println("}=== POKEDEX ========================{");
        for(Monster monster : pool){
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