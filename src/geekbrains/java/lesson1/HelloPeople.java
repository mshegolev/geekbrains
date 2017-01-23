package geekbrains.java.lesson1;

import java.io.PrintStream;

/**
 * Created by myname on 23.01.17.
 */
public class HelloPeople {
    public static void main(String[] args) {
        byte byteVariable = 1;
        short shortVariable = 31900;
        int integerVariable = 129;
        long longVariabel = 666777777555l;

        float floatVariable = 3.1416f;
        double doubleVariable = 123.234234d;

        char charVariableLetter = 's';
        char charVariableUnicod = 123;


        System.out.println(calculateFormula(1, 2, 3, 4));
        System.out.println(getDiffBetweenTentoTwenty(54, 6));
        System.out.println(getYear(1560));
        System.out.println("This is main programm");

    }

    private static int calculateFormula(int a, int b, int c, int d) {
        int result = a * (b + (c / d));
        System.out.format("a=%s,b=%s,c=%s,d=%s, result =%s", a, b, c, d, result);
        return result;

    }

    private static boolean getDiffBetweenTentoTwenty(int a, int b) {
        if (a + b <= 20 & a + b >= 10) {
            return true;
        } else {
            return false;
        }

    }

    private static PrintStream getYear(int year) {
        float result = year/4;
        return System.out.format("This %s year is leap",result);
    }

}
