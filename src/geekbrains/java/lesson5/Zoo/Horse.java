package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Horse extends Animal{
    public Horse(int age, String color, String name)
    {
        super(age,color,name);
    }

    @Override
    public boolean voice() {
    }

    @Override
    public boolean run() {
        return true;
    }
}
