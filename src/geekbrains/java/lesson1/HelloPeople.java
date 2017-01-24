package geekbrains.java.lesson1;

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
        System.out.println(getYear(2017));
        System.out.println("This is main programm");

    }

    private static int calculateFormula(int a, int b, int c, int d) {
        int result = a * (b + (c / d));
        System.out.format("a=%s,b=%s,c=%s,d=%s, result =%s", a, b, c, d, result);
        return result;

    }

    private static boolean getDiffBetweenTentoTwenty(int a, int b) {
        return a + b <= 20 & a + b >= 10;

    }

    private static String getYear(int year) {

        if (year <= 1000 & (year % 4) == 0) {
            return year + " - высокосный год";
        } else if ((year > 1000 & (year % 100) == 0 & (year % 400) == 0)) {
            return year + " - высокосный год";
        } else if (year > 1000 & (year % 4) == 0) {
            return year + " - высокосный год";
        } else return year + " - обычный год";
    }

}
