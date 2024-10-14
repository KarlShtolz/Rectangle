package org.example;

import java.util.Random;
//RandomGenerator.getTwoRandomNumber();
public class RandomGenerator {
    private static int x;
    private static int y;
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
