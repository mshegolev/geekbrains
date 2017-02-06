package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Cat extends Animal{
    public Cat(int age, String color, String name){
    super(age,color,name);
    }

    @Override
    public boolean voice(){
        System.out.println(this.name+" meows");
    }

    @Override
    public boolean run() {
        return false;
    }
}
