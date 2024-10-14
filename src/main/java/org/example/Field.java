package org.example;

public class Field {

    public static int fieldSide;
    private static char [][] field;
    public static void initField () {
        field = new char[fieldSide][fieldSide];
        for (int i = 0; i < fieldSide; i++) {
            for (int j = 0; j < fieldSide; j++) {
                field[i][j] = StringConstants.empty_cell_sign;
            }
        }
    }
    public static void setRectangleOnField (int gamer, int yStart, int xStart, int yEnd, int xEnd) {
        char gamerChar;
        int tmp;
        if (yStart > yEnd) {
            tmp = yStart;
            yStart = yEnd;
            yEnd = tmp;
        }
        if (xStart > xEnd) {
            tmp = xStart;
            xStart = xEnd;
            xEnd = tmp;
        }
        if (gamer == 1) {
            gamerChar = StringConstants.gamer1_sign;
        } else {
            gamerChar = StringConstants.gamer2_sign;
        }
        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                field[i][j] = gamerChar;
            }
        }
    }
    public static int checkEndGame (int yStart, int xStart, int yEnd, int xEnd) {

        return 0;
    }
    public static void gamersResult () {
        int countGamer1 = 0;
        int countGamer2 = 0;
        for (int i = 0; i < fieldSide; i++) {
            for (int j = 0; j < fieldSide; j++) {
                if (field[i][j] == StringConstants.gamer1_sign) {
                    countGamer1++;
                }
                if (field[i][j] == StringConstants.gamer2_sign) {
                    countGamer2++;
                }
            }
        }
        System.out.println("Gamer 1 result = " + countGamer1);
        System.out.println("Gamer 2 result = " + countGamer2);
    }
    public static int checkUserRectangleBounds (int yStart, int xStart, int yEnd, int xEnd) {
        if (xStart < 0 || yStart < 0 || xEnd < 0 || yEnd < 0
                || xStart > fieldSide - 1 || xEnd > fieldSide - 1
                || yStart > fieldSide - 1 || yEnd > fieldSide - 1) {
//            System.out.println(xStart + " " + yStart + " " + xEnd + " " + yEnd);
//            System.out.println(StringConstants.INDEX_OUT_OF_FIELD);
            return -1;
        }
        if (((Math.abs(xStart - xEnd) + 1) != RandomGenerator.getX()) &&
                ((Math.abs(yStart - yEnd) + 1) != RandomGenerator.getY())
        && (((Math.abs(xStart - xEnd) + 1) != RandomGenerator.getY()) &&
                ((Math.abs(yStart - yEnd) + 1) != RandomGenerator.getX()))) {
//            System.out.println("yStart="+yStart+" yEnd="+yEnd+" xStart="+xStart+" xEnd="+xEnd);
//            System.out.println(StringConstants.INVALID_INDEXES);
            return -2;
        }
        for (int i = yStart; i <= yEnd; i++) {
            for (int j = xStart; j <= xEnd; j++) {
                if (field[i][j] != StringConstants.empty_cell_sign) {
//                    System.out.println(StringConstants.TRY_TO_USE_NOT_EMPTY_CELL);
                    return -3;
                }
            }
        }
        return 0;
    }
    public static void transparentMatrix() {
        char [][] arr = new char[fieldSide][fieldSide];
        for (int i = 0; i < fieldSide; i++) {
            for (int j = 0; j < fieldSide; j++) {
                arr[i][j] = field[fieldSide - i - 1][fieldSide - j - 1];
            }
        }
        field = arr;
    }
    public static void printField () {
        System.out.print("   ");
        for (int k = 0; k < fieldSide; k++) {
            if (k < 10) {
                System.out.print(StringConstants.RED + k + "  ");
            } else {
                System.out.print(StringConstants.RED + k + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < fieldSide; i++) {
            if (i < 10) {
                System.out.print(StringConstants.RED + i + "  ");
            } else {
                System.out.print(StringConstants.RED + i + " ");
            }
            for (int j = 0; j < fieldSide; j++) {
                if (field[i][j] == StringConstants.gamer1_sign) {
                    System.out.print(StringConstants.PURPLE + field[i][j] + "  ");
                } else if (field[i][j] == StringConstants.gamer2_sign) {
                    System.out.print(StringConstants.YELLOW + field[i][j] + "  ");
                } else {
                    System.out.print(StringConstants.WHITE + field[i][j] + "  ");
                }
            }
            System.out.println();
        }
    }
}
