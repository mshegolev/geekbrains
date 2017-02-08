package geekbrains.java.lesson5;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public abstract class Animal {
    public String name;
    public String color;
    public int age;
    public int str;
    public int dex;
    public int sta;


    public Animal(int age, String color, String name) {
        this.name = name; //null
        this.color = color; //null
        this.age = age; //0
        this.str = str; //0
        this.dex = dex; //0
        this.sta = sta; //0
    }

    public Animal(int age, String color, String name, int str, int dex, int sta) {
        this.name = name; //null
        this.color = color; //null
        this.age = age; //0
        this.str = str; //0
        this.dex = dex; //0
        this.sta = sta; //0
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getSta() {
        return sta;
    }

    public abstract boolean isSwim(int i);
}
