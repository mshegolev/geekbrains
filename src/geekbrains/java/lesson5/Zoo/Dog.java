package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Dog extends Animal {

    public Dog(int age, String color, String name) {
        super(age, color, name);
    }

    @Override
    public void voice() {
        System.out.println(this.name + " woofs");
    }

    @Override
    public boolean run() {
        return true;
    }


    public boolean swim() {
        return true;
    }


    public boolean jump() {
        return true;
    }

}
