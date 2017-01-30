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

        System.out.println("This is main programm");

        int a = 1, b = 1, c = 1, d = 1;
        int result = calculateFormula(a, b, c, d);
        System.out.format("a=%s,b=%s,c=%s,d=%s, result =%s \n", a, b, c, d,result);

        if (getDiffBetweenTentoTwenty(5, 6)) System.out.println("Сумма чисел >10 и <20"); else System.out.println("Сумма чисел вне диапозона>10 и <20");

        int year = 2016;
        if (getYear(year)) System.out.println(year + " - высокосный год");
        else System.out.println(year + " - обычный год");

    }

    private static int calculateFormula(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }


    private static boolean getDiffBetweenTentoTwenty(int a, int b) {
        return a + b <= 20 & a + b >= 10;
    }

    private static boolean getYear(int year) {
        if (year <= 1000 & (year % 4) == 0) {
            return true;
        } else if ((year > 1000 & (year % 100) == 0 & (year % 400) == 0)) {
            return true;
        } else if (year > 1000 & (year % 4) == 0) {
            return true;
        } else return false;
    }

}
