package org.example;

import java.util.Scanner;

public class Player {
    public static Scanner sc;
    public static int [] coordinates = new int[]{-1, -1, -1, -1};
    public static void playGame (int player) throws InterruptedException {
        sc = new Scanner(System.in);
        String ans = "";
        Field.transparentMatrix();
        Field.printField();
        RandomGenerator.getTwoRandomNumber();
        System.out.println(StringConstants.GREEN + player + StringConstants.PLAYER + " y =" + RandomGenerator.getY() + " x =" + RandomGenerator.getX());
        System.out.println(StringConstants.GREEN + StringConstants.PASS_ROUND);
        ans = sc.nextLine();
        if (ans.equals(StringConstants.STRING_PASS)) {
            System.out.println(StringConstants.GREEN + StringConstants.NEXT_PLAYER_IN_GAME);
            GameStatus.incrementCount();
        } else {
            GameStatus.zeroCount();
            while (Field.checkUserRectangleBounds(coordinates[0], coordinates[1], coordinates[2], coordinates[3]) != 0) {
                System.out.println(StringConstants.GREEN + StringConstants.INPUT_COORDINATES);
                getArrCoordinates();
            }
            Field.setRectangleOnField(player, coordinates[0], coordinates[1], coordinates[2], coordinates[3]);
        }
        coordinates = new int[] {-1, -1, -1, -1};
    }
    public static void getArrCoordinates () {
        sc = new Scanner(System.in);
        String tmp = "";
        tmp = sc.nextLine();
        int count_spaces = 0;
        for (int i = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ' ') {
                count_spaces++;
            }
            if (!Character.isDigit(tmp.charAt(i)) && tmp.charAt(i) != ' ') {
                System.out.println(StringConstants.NOT_A_DIGIT_IN_INPUT);
                return;
            }
            if (count_spaces > 3) {
                System.out.println(StringConstants.TOO_MUCH_DIGITS);
                return;
            }
        }
        String [] arr = tmp.split(" ");
        for (int i = 0; i < arr.length; i++) {
            coordinates[i] = Integer.parseInt(arr[i]);
        }
    }
}
