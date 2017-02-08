package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Bird extends Animal {
    private int fliHeight;

    public Bird(int age, String color, String name) {
        super(age, color, name);
    }

    public Bird(int age, String color, String name, int fliHeight) {
        super(age, color, name);
        this.fliHeight = fliHeight;
    }

    public void voice() {
        System.out.println(this.name + " tweet");
    }

    public void fly() {
        if(this.fliHeight>0)
        System.out.println(this.name + " fly");
    }

}
