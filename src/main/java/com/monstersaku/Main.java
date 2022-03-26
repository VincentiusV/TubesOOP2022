package com.monstersaku;

import com.monstersaku.util.MonsterPool;
import com.monstersaku.util.Monster;
import com.monstersaku.util.Player;
import com.monstersaku.util.Stats;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // baca file Monsterpool
        MonsterPool monsterPool = new MonsterPool();
        List<Monster> pool = monsterPool.getPool();
        List<Monster> playerPool1 = new LinkedList<Monster>();
        List<Monster> playerPool2 = new LinkedList<Monster>();

        Player player1 = addMonster(playerPool1, pool);
        Player player2 = addMonster(playerPool2, pool);
        try {
            System.out.println("Pilihan Monster Anda: ");
            player1.printMonsterList();
            System.out.printf("Monster yang akan menyerang: ");
            Integer attackingMonster = scanner.nextInt();
            System.out.println("Pilihan Monster lawan: ");
            player2.printMonsterList();
            System.out.printf("Monster yang akan diserang: ");
            Integer defendingMonster = scanner.nextInt();

            System.out.println("Monster " + playerPool1.get(attackingMonster).getName() + " milik " + player1.getPlayerName() + " akan menyerang monster " + playerPool2.get(defendingMonster).getName() + " milik " + player2.getPlayerName());
            playerPool1.get(attackingMonster).fight(playerPool2.get(defendingMonster));
            playerPool2.get(defendingMonster).isDead();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("=== === END === ===");

//        Monster sugar = pool.get(1);
//        Stats stats = sugar.getBaseStats();
//        System.out.println();
//        System.out.println("Stats Sugar: ");
//        stats.printStats();
        // do nothing
    }
    public static Player addMonster(List<Monster> listName, List<Monster> pool){
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        for(int i=0; i<6; i++){
            listName.add(pool.get(Math.abs(rand.nextInt()%10)));
        }
        System.out.printf("Masukkan nama player: ");
        String name = scanner.next();
        Player player = new Player(name, listName);
        return player;
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
