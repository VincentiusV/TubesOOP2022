package com.monstersaku;

import com.monstersaku.util.MonsterPool;
import com.monstersaku.util.MovePool;
import com.monstersaku.util.Monster;
import com.monstersaku.util.Player;
import com.monstersaku.util.Stats;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // baca file monsterpool dan movepool
        MonsterPool monsterPool = new MonsterPool();
        List<Monster> pool = monsterPool.getPool();
        List<Monster> playerPool1 = new LinkedList<Monster>();
        List<Monster> playerPool2 = new LinkedList<Monster>();

        // minta MovePool dari monsterPool biar sama dengan yang ada di monsterpool
        MovePool movePool = monsterPool.getMovePool();
        movePool.printMovePool();

        /*
        Monster dah pasti punya skill kalau ada skillnya di monsterpool.csv
        Skill monster yang ada di csv ngga termasuk default, kalau mau bilang ya
        biar sekalian dibuat dari sananya langsung punya default.
        */
        int index_monster = 1; // index dimulai dari 0
        Monster monster = pool.get(index_monster);

        // Mulai testing ngeprint isinya
        System.out.println("Testing MovePool dan MonsterPool");
        movePool.printMovePool();
        System.out.println();
        monsterPool.printMonsterPool();
        System.out.println();
        
        System.out.println("Testing Player dan gameplay");
        System.out.println();
        System.out.printf("Masukkan nama player 1: ");
        String name1 = scanner.next();
        System.out.printf("Masukkan nama player 2: ");
        String name2 = scanner.next();
        Player player1 = addMonster(name1, playerPool1, pool);
        Player player2 = addMonster(name2, playerPool2, pool);
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
            if(playerPool2.get(defendingMonster).isDead()){
                System.out.println("Sayangnya monster " + playerPool2.get(defendingMonster).getName() + " sudah mati:(");
                player2.monsterDead(player2.getMonsterList().get(defendingMonster));
                player2.printMonsterList();
            }
            else{
                System.out.println("Monster " + playerPool2.get(defendingMonster).getName() + " memiliki sisa darah sebanyak " + playerPool2.get(defendingMonster).getBaseStats().getHP());
            }
            scanner.close();
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("=== === END === ===");

    }
    private static Player addMonster(String name, List<Monster> listName, List<Monster> pool){
        Random rand = new Random();
        for(int i=0; i<6; i++){
            listName.add(pool.get(Math.abs(rand.nextInt()%10)));
        }
        Player player = new Player(name, listName);
        return player;
    }
}
