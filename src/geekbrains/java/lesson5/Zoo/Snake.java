package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class Snake extends Animal{
    public Snake(int age, String color, String name) {
        super(age, color, name);
    }

    @Override
    public void walk(){
        System.out.println(this.name + " crawls");
    }

    @Override
    public void voice(){
        System.out.println(this.name+" SSSSHHHHSSSHHH");
    }
}
