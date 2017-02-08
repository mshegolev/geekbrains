package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Horse extends Animal {
    public Horse(int age, String color, String name, int str, int dex, int sta) {
        super(age, color, name, str, dex, sta);
    }

    public Horse(int age, String color, String name) {
        super(age, color, name, 10, 10, 10);
    }

    @Override
    public boolean isSwim(int i) {
        return false;
    }
}
