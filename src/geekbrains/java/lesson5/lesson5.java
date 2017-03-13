package geekbrains.java.lesson5;

import geekbrains.java.lesson5.Zoo.Actions;
import geekbrains.java.lesson5.Zoo.Cat;
import geekbrains.java.lesson5.Zoo.Dog;
import geekbrains.java.lesson5.Zoo.Horse;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class lesson5 {
    int i = 0;

    public static void main(String[] args) {
        Cat bars = new Cat(3, "Orange", "Barsik", 0, 2, 3);
        Dog shar = new Dog(3, "White", "Sharik", 2, 1, 1);
        Horse agat = new Horse(5, "White", "Agat", 15, 15, 15);
        Cat kitty = new Cat(1, "Blue", "Kitty");


        Animal[] zoo = {bars, shar, agat, kitty};
        int riverMeters[] = {2};
        int[] highMeters = {1, 2};
        int[] roadKm = {1, 5, 10};


        swimMarathon(zoo, riverMeters);
        runMarathon(zoo, roadKm);
        jumpMarathon(zoo, highMeters);


    }

    private static void jumpMarathon(Animal[] zoo, int[] distacne) {
        for (int i = 0; i < zoo.length; i++) {
            for (int j = 0; j < distacne.length; j++) {
                if (zoo[i] instanceof Horse) {
                    jump(zoo[i], distacne[j]);
                }
                if (zoo[i] instanceof Cat) {
                    jump(zoo[i], distacne[j]);
                }
                if (zoo[i] instanceof Dog) {
                    jump(zoo[i], distacne[j]);
                }
            }
        }
    }

    private static void swimMarathon(Animal[] zoo, int[] distance) {
        for (int i = 0; i < zoo.length; i++) {
            for (int j = 0; j < distance.length; j++) {
                if (zoo[i] instanceof Horse) {
                    swim(zoo[i], distance[j]);
                }
                if (zoo[i] instanceof Cat) {
                    swim(zoo[i], distance[j]);
                }
                if (zoo[i] instanceof Dog) {
                    swim(zoo[i], distance[j]);
                }
            }
        }
    }

    private static void runMarathon(Animal[] zoo, int[] distance) {
        for (int i = 0; i < zoo.length; i++) {
            for (int j = 0; j < distance.length; j++) {
                if (zoo[i] instanceof Horse) {
                    run(zoo[i], distance[j]);
                }
                if (zoo[i] instanceof Cat) {
                    run(zoo[i], distance[j]);
                }
                if (zoo[i] instanceof Dog) {
                    run(zoo[i], distance[j]);
                }

            }
        }
    }

    private static void jump(Animal animal, int distacne) {
        if (Actions.doJump(animal, distacne)) {
            System.out.println(animal.getName() + " Jump:" + distacne + " meters");
        } else System.out.println(animal.getName() + " don't jump");
    }

    private static void swim(Animal animal, int distacne) {
        if (Actions.doSwim(animal, distacne)) {
            System.out.println(animal.getName() + " Swim:" + distacne + " meters");
        } else System.out.println(animal.getName() + " don't swim");
    }

    private static void run(Animal animal, int distacne) {
        if (Actions.doRun(animal, distacne)) {
            System.out.println(animal.getName() + " Run:" + distacne + " meters");
        } else System.out.println(animal.getName() + " don't run");
    }


}

