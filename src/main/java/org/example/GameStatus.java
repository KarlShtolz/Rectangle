package org.example;
import java.util.Scanner;
public class GameStatus {
    public static String language = "";
    private static int count_no = 0;
    public static final int countEndGame = 1;

    public static void play () throws InterruptedException {
        int side = -1;
        Scanner sc = new Scanner(System.in);
        while (!language.equals(StringConstants.ENGLISH_LANGUAGE) && !language.equals(StringConstants.RUSSIAN_LANGUAGE)) {
            System.out.println(StringConstants.SELECT_LANGUAGE);
            language = sc.nextLine();
        }
        StringConstants.initLanguage(language);
        System.out.println(StringConstants.SET_FIELD_SIDE);
        side = sc.nextInt();
        while (side > 99 || side < 5) {
            System.out.println(StringConstants.SET_FIELD_SIDE);
            side = sc.nextInt();
        }
        Field.fieldSide = side;
        Field.initField();
        while (GameStatus.checkCount() != -1) {
            Player.playGame(1);
            System.out.println(GameStatus.checkCount());
            //System.out.println("count_no = " + GameStatus.getCount_no());
            Player.playGame(2);
            System.out.println(GameStatus.checkCount());
            //System.out.println("count_no = " + GameStatus.getCount_no());
        }
    }
    public static int checkCount () {
        if (count_no > countEndGame) {
            Field.gamersResult();
            System.out.println(StringConstants.END_GAME);
            System.exit(0);
            return -1;
        }
        return 0;
    }
    public static void incrementCount () {
        count_no++;
    }
    public static void zeroCount () {
        count_no = 0;
    }
    public static int getCount_no () {
        return count_no;
    }
}
