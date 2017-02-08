package geekbrains.java.lesson5.Zoo;

import geekbrains.java.lesson5.Animal;

/**
 * Created by mikhail.shchegolev on 08.02.2017.
 */
public class Actions {

    public static boolean doSwim(Animal animal, int riverMeter) {
        if ((riverMeter <= animal.getStr())) return true;
        return false;
    }

    public static boolean doRun(Animal animal, int meter) {
        if ((meter<= animal.getSta())) return true;
        return false;
    }

    public static boolean doJump(Animal animal, int high) {
        if ((high<= animal.getDex())) return true;
        return false;
    }
}
