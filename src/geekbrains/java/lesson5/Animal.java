package geekbrains.java.lesson5;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public abstract class Animal {
    public String name;
    public String color;
    public int age;

    public Animal(int age, String color, String name){
        this.name = name; //null
        this.color = color; //null
        this.age = age; //0
    }

    public void walk() {
        System.out.println(this.name+" walks");
    }

    public abstract boolean voice();

    public String getName() {
        return name;
    }

    public abstract boolean run();


}
