package geekbrains.java.lesson5;

import geekbrains.java.lesson5.Zoo.*;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class lesson5 {
    public static void main(String[] args) {
        Cat bars = new Cat(3, "Black", "Barsik");
        Dog shar = new Dog(3, "White", "Sharik");

        Bird koko = new Bird(1, "White", "Koko");
        Bird chij = new Bird(4, "Yellow", "Chij", 500);

        Parrot pol = new Parrot(4,"Rainbow","Polly",400);

        Snake kaa = new Snake(300,"Brown","Ka");



        Animal[] zoo = {bars,shar,koko,chij,pol,kaa};

        for (int i = 0; i < zoo.length; i++) {
            zoo[i].voice();
        }

        for (int i = 0; i < zoo.length; i++) {
            if(zoo[i] instanceof  Bird){
                System.out.println("Enlarged Cage for "+ zoo[i].getName());
            }
        }

        ((Parrot)pol).speak();

        /*shar.voice();
        bars.voice();
        chij.voice();
        koko.voice();
        pol.voice();*/

//        bars.walk();
//        shar.walk();
//        chij.walk();
//        koko.walk();
//        pol.walk();
//        kaa.walk();

//
//        koko.fly();
//        chij.fly();
//        pol.fly();

    }
}
