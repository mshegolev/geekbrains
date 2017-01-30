package geekbrains.java.lesson2;

import java.util.Scanner;

/**
 * Created by mikhail.shchegolev on 30.01.2017.
 */
public class Massive {


    public static void mainMethod() {
        //1 task
        int[] arrayFirstTask = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        //2 task
        invertArraySecondTask(arrayFirstTask);


        //3 task
        int[] arrayThirdTask = new int[8];
        putArrayThirdParty(arrayThirdTask);


        //4 task
        int[] mas = {1, 5, 3, 2, 11, 6, 5, 2, 4, 8, 9, 1};
        dubleSixForthTask(mas);


        //5 task
        System.out.println(getMaxValue(mas));
        System.out.println(getMinValue(mas));

        //6 task
        calc();


    }

    private static void calc() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите число один:");
        int a = sc.nextInt();
        System.out.println("Введите действие (+-*/):");
        String b = sc.next();
        System.out.println("Введите число два:");
        int c = sc.nextInt();
        int r = 0;
        switch (b) {
            case "+":
                r = a + c;
                break;
            case "-":
                r = a - c;
                break;
            case "*":
                r = a * c;
                break;
            case "/":
                r = a / c;
                break;
        }
        System.out.println("Введенное вами число" + a + ", " + b + " на " + c + ", равно " + r);
    }

    private static int getMaxValue(int[] array) {
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (value <= array[i]) value = array[i];
        }
        return value;
    }

    private static int getMinValue(int[] array) {
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= value) value = array[i];
        }
        return value;
    }


    private static void dubleSixForthTask(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            int i1 = (mas[i] < 6) ? mas[i] *= 2 : mas[i];
        }
    }

    private static void check(int[] arrayThirdTask) {
        for (int i = 0; i < arrayThirdTask.length; i++) {
            System.out.println(arrayThirdTask[i]);
        }
    }

    private static void putArrayThirdParty(int[] arrayThirdTask) {
        int[] templateThirdTask = {1, 4, 7, 10, 13, 16, 19, 22};
        for (int i = 0; i < arrayThirdTask.length; i++) {
            arrayThirdTask[i] = templateThirdTask[i];
        }
    }

    public static void invertArraySecondTask(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] = 1;
            } else if (a[i] == 1) {
                a[i] = 0;
            }

            /*
            a[i] == 0 ? a[i]=1 : a[i]=0;

            почему этот код не работает Error:(18, 22) java: unexpected type
            required: variable
            found:    value
            */
        }


    }

}
