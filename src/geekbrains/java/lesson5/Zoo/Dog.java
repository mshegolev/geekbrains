package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Dog extends Animal {

    public Dog(int age, String color, String name, int str, int dex, int sta) {
        super(age, color, name, str, dex, sta);
    }

    @Override
    public boolean isSwim(int i) {
        return false;
    }


}
