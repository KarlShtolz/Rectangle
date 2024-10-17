package org.example;

public class Field {
    /**
     * ширина игрового поля
     */
    public static int fieldSide;
    /**
     * двумерный массив символов используемый в качестве поля
     */
    private static char [][] field;

    /**
     * создает двумерный массив по заданным пользователям размерам
     * и заполняет его символами пустых ячеек поля
     */
    public static void initField () {
        field = new char[fieldSide][fieldSide];
        for (int i = 0; i < fieldSide; i++) {
            for (int j = 0; j < fieldSide; j++) {
                field[i][j] = StringConstants.empty_cell_sign;
            }
        }
    }

    /**
     * метод получает индекс игрока, координаты прямоугольника игрока
     * и заполняет выбранный прямоугольник в матрице символом данного игрока
     * @param gamer
     * @param yStart
     * @param xStart
     * @param yEnd
     * @param xEnd
     */
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

    /**
     * TODO метод проверки состояния игры на предмет невозможности хода
     * @return
     */
    public static int checkEndGame () {

        return 0;
    }

    /**
     * метод выводит на экран результаты игроков
     */
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
        System.out.println(StringConstants.FIRST_PLAYER_GAME_RESULT + countGamer1);
        System.out.println(StringConstants.SECOND_PLAYER_GAME_RESULT + countGamer2);
    }

    /**
     * метод проверяет координаты введенные игроком
     * на предмет соответствия правилам игры
     * @param yStart
     * @param xStart
     * @param yEnd
     * @param xEnd
     * @return -1 - индекс за пределами поля
     *         -2 - индексы создают рпямоугольник неверного размера(относительно выпавших игроку размеров)
     *         -3 - попытка использовать занятую ячейку
     *          0 - положительный результат проверки
     */
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

    /**
     * метод транспонирует матрицу, чтобы оба игрока видели поле симметрично
     */
    public static void transparentMatrix() {
        char [][] arr = new char[fieldSide][fieldSide];
        for (int i = 0; i < fieldSide; i++) {
            for (int j = 0; j < fieldSide; j++) {
                arr[i][j] = field[fieldSide - i - 1][fieldSide - j - 1];
            }
        }
        field = arr;
    }

    /**
     * матод выводит текущее состояние поля
     */
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
