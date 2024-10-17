package org.example;

import java.util.Random;
//RandomGenerator.getTwoRandomNumber();
public class RandomGenerator {
    /**
     * параметр для ширины поля, полученного пользователем от броска кубика
     */
    private static int x;
    /**
     * параметр для высоты поля, полученного пользователем от броска кубика
     */
    private static int y;

    /**
     * метод для получения двух рандомных чисел
     * (имитация броска двух кубиков со сторонами от 1 до 6 включительно)
     * @throws InterruptedException
     */
    public static void getTwoRandomNumber () throws InterruptedException {
        Random random1 = new Random();
        x = random1.nextInt(6) + 1;
        random1 = new Random();
        y = random1.nextInt(6) + 1;
    }
    public static int getX() {
        return x;
    }
    public static int getY () {
        return y;
    }
}
