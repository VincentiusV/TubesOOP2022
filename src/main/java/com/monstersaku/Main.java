package com.monstersaku;

import com.monstersaku.util.MonsterPool;
import com.monstersaku.util.Monster;
import com.monstersaku.util.Player;
import com.monstersaku.util.Stats;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // baca file Monsterpool
        MonsterPool monsterPool = new MonsterPool();
        monsterPool.printMonsterPool();
        List<Monster> pool = monsterPool.getPool();
        List<Monster> playerPool = new LinkedList<Monster>();
        for(int i=0; i<6; i++){
            Random rand = new Random();
            playerPool.add(pool.get(rand.nextInt()%100));
        }
        Player player1 = new Player("TesName", playerPool);
        for(int i=0; i<playerPool.size(); i++){
            player1.printMonsterList();
        }
        System.out.println("=== === END === ===");
//        Monster sugar = pool.get(1);
//        Stats stats = sugar.getBaseStats();
//        System.out.println();
//        System.out.println("Stats Sugar: ");
//        stats.printStats();
          // do nothing
    }





        




        /*for (String fileName : CSV_FILE_PATHS) {
            try {
                System.out.printf("Filename: %s\n", fileName);
                CSVReader reader = new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";");
                reader.setSkipHeader(true);
                List<String[]> lines = reader.read();
                System.out.println("=========== CONTENT START ===========");
                for (String[] line : lines) {
                    for (String word : line) {
                        System.out.printf("%s ||", word);
                    }
                    System.out.println();
                }
                System.out.println("=========== CONTENT END ===========");
                System.out.println();
            } catch (Exception e) {
                // do nothing
            }
        }*/
}
