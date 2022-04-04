package com.monstersaku;

import com.monstersaku.util.MonsterPool;
import com.monstersaku.util.MovePool;
import com.monstersaku.util.ElementType;
import com.monstersaku.util.Monster;
import com.monstersaku.util.Move;
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
         * Monster dah pasti punya skill kalau ada skillnya di monsterpool.csv
         * Skill monster yang ada di csv ngga termasuk default, kalau mau bilang ya
         * biar sekalian dibuat dari sananya langsung punya default.
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

        // inisialisasi
        System.out.println("Inisialisasi...");
        System.out.println("SELAMAT DATANG DI MONSTER SAKU!! (definitely not pokemon)");
        System.out.printf("Masukkan nama player 1: ");
        String name1 = scanner.next();
        System.out.printf("Masukkan nama player 2: ");
        String name2 = scanner.next();
        Player player1 = addMonster(name1, playerPool1, pool);
        Player player2 = addMonster(name2, playerPool2, pool);
        try {
            // Milih monster pertama
            List<ElementType> tempElementType = new LinkedList<ElementType>();
            Stats tempStats = new Stats(1, 1, 1, 1, 1, 1);
            Monster tempMonster = new Monster("missingno", tempElementType, tempStats);

            Monster monster1 = tempMonster;
            Monster monster2 = tempMonster;
            monster1 = selectMonster(player1, scanner, monster1);
            monster2 = selectMonster(player2, scanner, monster2);

            // start gameloop
            while (player1.isHaveMonster() && player2.isHaveMonster()) {
                while (!monster1.isDead() && !monster2.isDead()) {

                    // Player 1
                    System.out.printf("%s turn.%n", player1.getPlayerName());
                    Integer choice = battleMenu(monster1, scanner);
                    if (choice.equals(1)) {
                        Move monsterMove = chooseMove(monster1, monster2, scanner);
                        // masukin penggunaan move dari monster yang nyerang
                    } else if (choice.equals(2)) { // select monster
                        monster1 = selectMonster(player1, scanner, monster1);
                    }
                    // Player 2
                    System.out.printf("%s turn.%n", player2.getPlayerName());
                    choice = battleMenu(monster2, scanner);
                    if (choice.equals(1)) {
                        Move monsterMove = chooseMove(monster2, monster1, scanner);
                        // masukin penggunaan move dari monster yang nyerang
                    } else if (choice.equals(2)) { // select monster
                        monster1 = selectMonster(player2, scanner, monster2);
                    }
                }
                if (monster1.isDead() && player1.isHaveMonster()) {
                    player1.monsterDead(monster1);
                    System.out.printf("%s pingsan!!! Pilih monster lainnya!%n", monster1.getName());
                    monster1 = selectMonster(player1, scanner, monster1);
                }
                if (monster2.isDead() && player2.isHaveMonster()) {
                    player2.monsterDead(monster2);
                    System.out.printf("%s pingsan!!! Pilih monster lainnya!%n", monster2.getName());
                    monster2 = selectMonster(player2, scanner, monster2);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("=== === END === ===");

    }

    private static Player addMonster(String name, List<Monster> listName, List<Monster> pool) {
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            listName.add(pool.get(Math.abs(rand.nextInt() % 10)));
        }
        Player player = new Player(name, listName);
        return player;
    }

    // method game
    public static void PrintBattleMenu(Monster monster) {
        System.out.printf("Apa yang akan %s lakukan?%n", monster.getName());
        System.out.println("==== SELECTION MENU ====");
        System.out.println("1. Move");
        System.out.println("2. Switch Monster");
        System.out.printf("Pilihan Anda (dalam angka): ");
    }

    public static void printChooseMonster(Player player) {
        System.out.printf("Pilihan Monster %s: %n", player.getPlayerName());
        player.printMonsterList();
        System.out.printf("Monster yang akan menyerang: ");
    }

    public static Move chooseMove(Monster monster1, Monster monster2, Scanner scanner) {
        monster1.printMonsterMoves();
        Move move;
        System.out.printf("Pilih move apa yang akan dilakukan oleh %s kepada %s: %n", monster1.getName(),
                monster2.getName());
        int index = scanner.nextInt();

        move = monster1.getMoveList().get(index);
        List<Move> movelist = monster1.getMoveList();
        while (index >= monster1.getMoveList().size() || index < 0) { 
            // saya ada ide buat nerapin exception tapi mengmager
            System.out.println("Input diluar range daftar move monster");
            System.out.print("Masukkan input yang benar: ");
            index = scanner.nextInt();
            move = monster1.getMoveList().get(index);
        }

        return move;
    }
    public static Monster selectMonster(Player player, Scanner scanner, Monster currmonster) {
        printChooseMonster(player);
        int index = scanner.nextInt();
        List<Monster> monsterlist = player.getMonsterList();
        int currindex = monsterlist.indexOf(currmonster);
        while (index == currindex || index >= monsterlist.size()
                || index < 0) {
            if (index == currindex) {
                System.out.println("Pilihan anda merupakan monster yang sekarang anda pakai.");
            } else if (index >= monsterlist.size() || index < 0) {
                System.out.println("Pilihan anda berada diluar index monster yang anda miliki.");
            }
            System.out.print("Masukkan pilihan anda: ");
            index = scanner.nextInt();
        }
        Monster monster = player.getMonsterList().get(index);
        System.out.printf("%s : %s, saya memilih mu!%n", player.getPlayerName(), monster.getName());
        return monster;
    }

    public static int battleMenu(Monster monster, Scanner scanner) {
        PrintBattleMenu(monster);
        int choice = scanner.nextInt();
        return choice;
    }

    public static Monster dOTeffect(Monster monster){
        return monster;
    }
}
