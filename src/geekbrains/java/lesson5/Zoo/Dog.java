package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Dog extends Animal{

    public Dog(int age, String color, String name){
        super(age, color, name);
    }
    @Override
    public boolean voice(){
        System.out.println(this.name+" woofs");
    }

}
