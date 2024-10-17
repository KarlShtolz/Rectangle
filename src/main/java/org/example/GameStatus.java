package org.example;
import java.util.Scanner;
public class GameStatus {
    /**
     * переменная для хранения текущего языка игры
     */
    public static String language = "";
    /**
     * переменная для хранения количества отказов от хода обоих игроков
     */
    private static int count_no = 0;
    /**
     * переменная задающая предельное количество отказов от хода,
     * после которого игра заканчивается
     */
    public static final int countEndGame = 1;

    /**
     * основной метод запускающий игру
     * @throws InterruptedException
     */
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
            Player.playGame(2);
            System.out.println(GameStatus.checkCount());
        }
    }

    /**
     * метод завершает игру, если count_no становится больше чем countEndGame
     * @return
     */
    public static int checkCount () {
        if (count_no > countEndGame) {
            Field.gamersResult();
            System.out.println(StringConstants.END_GAME);
            System.exit(0);
            return -1;
        }
        return 0;
    }

    /**
     * увеличение значения счетчика отказов от хода
     */
    public static void incrementCount () {
        count_no++;
    }

    /**
     * обнуление счетчика отказов от хода
     */
    public static void zeroCount () {
        count_no = 0;
    }

    /**
     * получение текущего значения отказов от хода
     * @return
     */
    public static int getCount_no () {
        return count_no;
    }
}
