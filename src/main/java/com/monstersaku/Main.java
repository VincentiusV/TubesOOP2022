package com.monstersaku;

import com.monstersaku.util.*;
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
            System.out.printf("Masukkan pilihan Anda: ");
            command = scanner.nextLine();
            if (command.equals("Help")) {
                help();
            } else if (command.equals("Exit")) {
                System.out.println("Sampai jumpa!! Semoga Sugar memberkati anda!!");
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
    /**
     * Memasukkan move kembali kedalam list
     * @param move,movelist
     * @return movelist
     */
    public static List<Move> giveRenewedMove(Move move, List<Move> movelist){

        if(move.getAmmunition() > 0){
            int index = movelist.indexOf(move);
            movelist.set(index, move);
        }
        else{
            movelist.remove(move);
        }
        return movelist;
    }

    public static Move chooseMove(Monster monster1, Monster monster2, Scanner scanner) {
        monster1.printMonsterMoves();
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

    /**
     * Mengembalikan input yang diberikan oleh yaitu index yang
     * dimaksudkan untuk melihat monster yang dimiliki player
     */
    public static int selectMonster(Player player, Scanner scanner) {
        System.out.printf("Pilihan Monster %s: %n", player.getPlayerName());
        player.printMonsterList();
        System.out.printf("Monster yang akan digunakan %s: ", player.getPlayerName());
        int index = scanner.nextInt();
        List<Monster> monsterlist = player.getMonsterList();
        int currindex = player.getCurrentMonsterIndex();
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
        System.out.println();
        return index;
    }

    public static int battleMenu(MonsterPool monsterPool, int turn, Player player, Monster monster,
            Scanner scanner) {
        System.out.printf("%s HP: %.2f%n",monster.getName(), monster.getBaseStats().getHP());
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
                System.out.printf("Apa yang akan %s lakukan?%n", monster.getName());
                System.out.println("==== SELECTION MENU ====");
                System.out.println("1. Move");
                System.out.println("2. Switch Monster");
                System.out.println("3. View Monster Info");
                System.out.println("4. View Game Info");
                System.out.println();
                System.out.printf("Pilihan Anda: ");
                choice = scanner.nextInt();
            } else if (choice.equals(4)) {
                viewGameInfo(monster, player, turn);
                System.out.printf("Apa yang akan %s lakukan?%n", monster.getName());
                System.out.println("==== SELECTION MENU ====");
                System.out.println("1. Move");
                System.out.println("2. Switch Monster");
                System.out.println("3. View Monster Info");
                System.out.println("4. View Game Info");
                System.out.println();
                System.out.printf("Pilihan Anda: ");
                choice = scanner.nextInt();
                System.out.println();
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
        System.out.printf("Inisialisasi.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
            // inisiasi monster
            player1.setCurrentMonsterIndex(selectMonster(player1, scanner));
            player2.setCurrentMonsterIndex(selectMonster(player2, scanner));
            Monster monster1 = player1.getMonsterList().get(player1.getCurrentMonsterIndex());
            Monster monster2 = player2.getMonsterList().get(player2.getCurrentMonsterIndex());
            Move monsterMove1 = null;
            Move monsterMove2 = null;

            // start gameloop
            while (player1.isHaveMonster() && player2.isHaveMonster()) {
                turn += 1;
                System.out.printf("TURN %d.", turn);
                // Player 1 Choosing Action

                if (monster1.isDead()) {
                    player1.monsterDead(monster1);
                    if(!player1.isHaveMonster()){break;}
                    System.out.printf("%s pingsan!!! Pilih monster lainnya!%n", monster1.getName());
                    // set new monster for player 1
                    player1.setCurrentMonsterIndex(selectMonster(player1, scanner));
                    monster1 = player1.getMonsterList().get(player1.getCurrentMonsterIndex());
                } else {

                    System.out.printf("%s turn.%n", player1.getPlayerName());
                    choice = battleMenu(monsterPool, turn, player1, monster1, scanner);
                    if (choice.equals(1)) {
                        monsterMove1 = chooseMove(monster1, monster2, scanner);

                    } else if (choice.equals(2)) { // select monster
                        // set new monster for player 1
                        player1.setCurrentMonsterIndex(selectMonster(player1, scanner));
                        monster1 = player1.getMonsterList().get(player1.getCurrentMonsterIndex());
                    }
                    System.out.println();
                }

                // Player 2 Choosing Action
                if (monster2.isDead()) {
                    player2.monsterDead(monster2);
                    if(!player2.isHaveMonster()){break;}
                    System.out.printf("%s pingsan!!! Pilih monster lainnya!%n", monster2.getName());
                    // set new monster for player 2
                    player2.setCurrentMonsterIndex(selectMonster(player2, scanner));
                    monster2 = player2.getMonsterList().get(player2.getCurrentMonsterIndex());

                } else {
                    System.out.printf("%s turn.%n", player2.getPlayerName());
                    choice = battleMenu(monsterPool, turn, player2, monster2, scanner);
                    if (choice.equals(1)) {
                        monsterMove2 = chooseMove(monster2, monster1, scanner);
                    } else if (choice.equals(2)) { // select monster
                        player2.setCurrentMonsterIndex(selectMonster(player2, scanner));
                        monster2 = player2.getMonsterList().get(player2.getCurrentMonsterIndex());
                    }
                }
                // Action in progress {disini DOT, nerima damage, heal disini}
                // check siapa duluan
                int urutanType = 0;
                if(monsterMove1 != null && monsterMove2 != null){
                    if(monsterMove1.getPriority() == monsterMove2.getPriority()){
                        if(monster1.getBaseStats().getSpeed() > monster2.getBaseStats().getSpeed()){
                            urutanType = 1;
                        }
                        else if(monster1.getBaseStats().getSpeed() < monster2.getBaseStats().getSpeed()){
                            urutanType = 2;
                        }
                        else{
                            urutanType = new Random().nextInt(2) + 1;
                        }
                    }
                    else if(monsterMove1.getPriority() < monsterMove2.getPriority()){
                        urutanType = 2;
                    }
                    else{
                        urutanType = 1;
                    }
                    switch(urutanType){
                        case 1:
                        // player 1 do the thing
                        if(monsterMove1.getTarget() == "OWN"){
                            monsterMove1.useMove(monster1, monster1);
                        } else{
                            monsterMove1.useMove(monster1, monster2);
                        }
                        monster1.setMoveList(giveRenewedMove(monsterMove1, monster1.getMoveList()));
                        monsterMove1 = null;

                        // player 2 do the thing
                        if(monsterMove2.getTarget() == "OWN"){
                            monsterMove2.useMove(monster2, monster2);
                        } else{
                            monsterMove2.useMove(monster2, monster1);
                        }
                        monster2.setMoveList(giveRenewedMove(monsterMove2, monster2.getMoveList()));
                        monsterMove2 = null;
                        break;

                        case 2:
                        // player 2 do the thing
                        if(monsterMove2.getTarget() == "OWN"){
                            monsterMove2.useMove(monster2, monster2);
                        } else{
                            monsterMove2.useMove(monster2, monster1);
                        }
                        monster2.setMoveList(giveRenewedMove(monsterMove2, monster2.getMoveList()));
                        monsterMove2 = null;

                        // player 1 do the thing
                        if(monsterMove1.getTarget() == "OWN"){
                            monsterMove1.useMove(monster1, monster1);
                        } else{
                            monsterMove1.useMove(monster1, monster2);
                        }
                        monster1.setMoveList(giveRenewedMove(monsterMove1, monster1.getMoveList()));
                        monsterMove1 = null;
                        break;
                    }
                }
            }
            if(player1.isHaveMonster()){
                System.out.printf("Permainan telah berakhir! Pemenangnya adalah... %s!!!%n", player1.getPlayerName());
            } else if(player2.isHaveMonster()){
                System.out.printf("Permainan telah berakhir! Pemenangnya adalah... %s!!!%n", player2.getPlayerName());
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
        player.printMonsterList();
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ");
    }
}
