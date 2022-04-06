package com.monstersaku;

import com.monstersaku.util.MonsterPool;
import com.monstersaku.util.MovePool;
import com.monstersaku.util.NormalMove;
import com.monstersaku.util.ElementType;
import com.monstersaku.util.Monster;
import com.monstersaku.util.Move;
import com.monstersaku.util.Player;
import com.monstersaku.util.Stats;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean end = false;
        String command;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Monster Saku");
        System.out.printf("%n%n%n");
        System.out.println("1. Start Game");
        System.out.println("2. Help");
        System.out.println("3. Exit");

        // inisialisasi
        while (!end) {
            command = scanner.nextLine();
            if (command.equals("Help")) {
                help();
            } else if (command.equals("Exit")) {
                end = true;
            } else if (command.equals("Start Game")) {
                gameplay(scanner);
            } else {
                System.out.println("Masukan anda salah atuhhh, cuma ada 3 pilihannya!");
                System.out.println("1. Start Game");
                System.out.println("2. Help");
                System.out.println("3. Exit");
            }
        }
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
    public static void printChooseMonster(Player player) {
        System.out.printf("Pilihan Monster %s: %n", player.getPlayerName());
        player.printMonsterList();
        System.out.printf("Monster yang akan digunakan %s: ", player.getPlayerName());
    }

    public static Move chooseMove(Monster monster1, Monster monster2, Scanner scanner) {
        monster1.printMonsterMoves();
        Move move;
        System.out.printf("Pilih move apa yang akan dilakukan oleh %s kepada %s: %n", monster1.getName(),
                monster2.getName());
        int index = scanner.nextInt();
        while (index >= monster1.getMoveList().size() || index < 0) {
            // saya ada ide buat nerapin exception tapi mengmager
            System.out.println("Input diluar range daftar move monster");
            System.out.print("Masukkan input yang benar: ");
            index = scanner.nextInt();
        }

        return monster1.getMoveList().get(index);
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

    public static int battleMenu(MonsterPool monsterPool, int turn, Player player, Monster monster,
            Scanner scanner) {
        System.out.printf("Apa yang akan %s lakukan?%n", monster.getName());
        System.out.println("==== SELECTION MENU ====");
        System.out.println("1. Move");
        System.out.println("2. Switch Monster");
        System.out.println("3. View Monster Info");
        System.out.println("4. View Game Info");
        System.out.println();
        System.out.printf("Pilihan Anda: ");
        Integer choice = scanner.nextInt();
        while (!choice.equals(1) && !choice.equals(2)) {
            if (choice.equals(3)) {
                viewMonsterInfo(monsterPool);
            } else if (choice.equals(4)) {
                viewGameInfo(monster, player, turn);
            }
        }
        return choice;
    }

    public static Monster dOTeffect(Monster monster) {
        if (monster.getconditionList(0)) {

        }
        return monster;
    }

    public static void gameplay(Scanner scanner) {
        // attribute
        int turn = 0;
        Integer choice;
        System.out.println("Inisialisasi...");
        MonsterPool monsterPool = new MonsterPool();
        List<Monster> pool = monsterPool.getPool();
        List<Monster> playerPool1 = new LinkedList<Monster>();
        List<Monster> playerPool2 = new LinkedList<Monster>();

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
                turn += 1;
                // Player 1
                if (monster1.isDead() && player1.isHaveMonster()) {
                    player1.monsterDead(monster1);
                    System.out.printf("%s pingsan!!! Pilih monster lainnya!%n", monster1.getName());
                    monster1 = selectMonster(player1, scanner, monster1);
                } else {
                    System.out.printf("%s turn.%n", player1.getPlayerName());
                    choice = battleMenu(monsterPool, turn, player1, monster1, scanner);
                    if (choice.equals(1)) {
                        Move monsterMove = chooseMove(monster1, monster2, scanner);
                        // masukin penggunaan move dari monster yang nyerang
                    } else if (choice.equals(2)) { // select monster
                        monster1 = selectMonster(player1, scanner, monster1);
                    }
                }

                // Player 2
                if (monster2.isDead() && player2.isHaveMonster()) {
                    player2.monsterDead(monster2);
                    System.out.printf("%s pingsan!!! Pilih monster lainnya!%n", monster2.getName());
                    monster2 = selectMonster(player2, scanner, monster2);
                } else {
                    System.out.printf("%s turn.%n", player2.getPlayerName());
                    choice = battleMenu(monsterPool, turn, player2, monster2, scanner);
                    if (choice.equals(1)) {
                        Move monsterMove = chooseMove(monster2, monster1, scanner);
                        // masukin penggunaan move dari monster yang nyerang
                    } else if (choice.equals(2)) { // select monster
                        monster2 = selectMonster(player2, scanner, monster2);
                    }
                    // DOT in effect
                    monster1 = dOTeffect(monster1);
                    monster2 = dOTeffect(monster2);
                }
                if (monster1.isDead() && player1.isHaveMonster()) {
                    player1.monsterDead(monster1);
                    System.out.printf("%s pingsan!!! Pilih monster lainnya!%n", monster1.getName());
                    monster1 = selectMonster(player1, scanner, monster1);
                }

            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("=== === END === ===");
    }

    public static void help() {
        System.out.println("}ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ HELP ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ{");
        System.out.println("Selamat Datang di MONSTER SAKU!! (definitely not pokemon rip off");
        System.out.println();
        System.out.println("Permainan hanya akan selesai jika minimal 1 pemain tidak memiliki monster sehat walafiat");
        System.out.println("Pada saat memulai pertandingan, anda dan musuh anda akan disuruh mengisi nama dan memilih");
        System.out
                .println("monster yang ingin anda pakai untuk mengalahkan musuh anda. Setelah itu anda dapat memilih");
        System.out.println("apa yang ingin anda lakukan. Terdapat 4 pilihan, yaitu Move dan Switch.");
        System.out.println(
                "Pilihan Move digunakan jika anda ingin monster saku anda melakukan suatu aksi. Sementara Pilihan");
        System.out.println(
                "Switch, digunakan untuk menukar monster saku sekarang. Jika monster saku anda pingsan, anda akan");
        System.out.println("dipaksa melakukan Switch!");
        System.out.println("Pilihan ketiga adalah pilihan melihat info monster yang ada saat permainan");
        System.out.println("Gunakan strategi anda sebaik mungkin dan kalahkan musuh anda!");
        System.out.println("Semoga berkah Sugar memberkati anda");
    }

    public static void viewMonsterInfo(MonsterPool monsterPool) {
        monsterPool.printMonsterPool();
    }

    public static void viewGameInfo(Monster monster, Player player, int turn) {
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
        System.out.printf("Sekarang turn %d%n%n%n", turn);
        System.out.printf("Monster yang digunakan saat ini:%n%n%n");
        System.out.println("Stats: ");
        monster.getBaseStats().printStats();
        System.out.println("Move: ");
        monster.printMonsterMoves();
        System.out.printf("%n%nMonster yang anda miliki");
        player.printMonsterList();
    }
}
