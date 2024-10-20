package org.example;

public class StringConstants {
    /**
     * цвет для консольного вывода(RED)
     */
    public static final String RED = "\u001B[31m";
    /**
     * цвет для консольного вывода(GREEN)
     */
    public static final String GREEN = "\u001B[32m";
    /**
     * цвет для консольного вывода(YELLOW)
     */
    public static final String YELLOW = "\u001B[33m";
    /**
     * цвет для консольного вывода(BLUE)
     */
    public static final String BLUE = "\u001B[34m";
    /**
     * цвет для консольного вывода(PURPLE)
     */
    public static final String PURPLE = "\u001B[35m";
    /**
     * цвет для консольного вывода(CYAN)
     */
    public static final String CYAN = "\u001B[36m";
    /**
     * цвет для консольного вывода(WHITE)
     */
    public static final String WHITE = "\u001B[37m";
    /**
     * символ для обозначения поля первого игрока
     */
    public static char gamer1_sign = '$';
    /**
     * символ для обозначения поля второго игрока
     */
    public static char gamer2_sign = '%';
    /**
     * символ для обозначения пустой ячейки на поле
     */
    public static char empty_cell_sign = '+';
    public static final String SELECT_LANGUAGE = "Select language(EN)/ Выберите язык(RU)";
    public static final String ENGLISH_LANGUAGE = "EN";
    public static final String RUSSIAN_LANGUAGE = "RU";

    public static String INDEX_OUT_OF_FIELD = "";
    public static String INVALID_INDEXES = "";
    public static String TRY_TO_USE_NOT_EMPTY_CELL = "";
    public static String SET_FIELD_SIDE = "";
    public static String END_GAME = "";
    public static String PASS_ROUND = "";
    public static String STRING_PASS = "";
    public static String NEXT_PLAYER_IN_GAME = "";
    public static String INPUT_COORDINATES = "";
    public static String NOT_A_DIGIT_IN_INPUT = "";
    public static String TOO_MUCH_DIGITS = "";
    public static String PLAYER = "";
    public static String FIRST_PLAYER_GAME_RESULT = "";
    public static String SECOND_PLAYER_GAME_RESULT = "";
    public static void initLanguage (String language) {
        if (language.equals(ENGLISH_LANGUAGE)) {
            INDEX_OUT_OF_FIELD = "INDEX_OUT_OF_FIELD!";
            INVALID_INDEXES = "INVALID_INDEXES!";
            TRY_TO_USE_NOT_EMPTY_CELL = "TRY_TO_USE_NOT_EMPTY_CELL!";
            SET_FIELD_SIDE = "Set field side for game(field_side > 5 and field_side < 99)";
            END_GAME = "End game!";
            PASS_ROUND = "if you want pass this round press PASS";
            STRING_PASS = "PASS";
            NEXT_PLAYER_IN_GAME = "Next player in game";
            INPUT_COORDINATES = "Please send 4 numbers. yStart xStart yEnd xEnd for your rectangle";
            NOT_A_DIGIT_IN_INPUT = "Not a digit in input";
            TOO_MUCH_DIGITS = "Too much digits";
            PLAYER = "player";
            FIRST_PLAYER_GAME_RESULT = "First player game result = ";
            SECOND_PLAYER_GAME_RESULT = "Second player game result = ";
        } else if (language.equals(RUSSIAN_LANGUAGE)) {
            INDEX_OUT_OF_FIELD = "Индекс за пределами поля";
            INVALID_INDEXES = "Неверный индекс";
            TRY_TO_USE_NOT_EMPTY_CELL = "Попытка использовать занятую ячейку";
            SET_FIELD_SIDE = "Задайте размер поля(сторона > 5 и сторона < 99)";
            END_GAME = "Конец игры!";
            PASS_ROUND = "Если хотите пропустить этот раунд введите ПАС";
            STRING_PASS = "ПАС";
            NEXT_PLAYER_IN_GAME = "Следующий игрок";
            INPUT_COORDINATES = "Введите 4 координаты yStart xStart yEnd xEnd для вашего прямоугольника";
            NOT_A_DIGIT_IN_INPUT = "Во введенных данных не числа";
            TOO_MUCH_DIGITS = "Слишком много чисел";
            PLAYER = "игрок";
            FIRST_PLAYER_GAME_RESULT = "Результат первого игрока = ";
            SECOND_PLAYER_GAME_RESULT = "Результат второго игрока = ";
        } else {
            System.out.println("Unsupported language!");
            throw new RuntimeException();
        }
    }
}
