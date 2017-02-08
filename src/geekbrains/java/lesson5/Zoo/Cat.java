package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Cat extends Animal {
    public Cat(int age, String color, String name, int str, int dex, int sta) {
        super(age, color, name, str, dex, sta);
    }

    public Cat(int age, String color, String name) {
        super(age, color, name, 0, 1, 1);
    }

    @Override
    public boolean isSwim(int i) {
        return false;
    }
}
