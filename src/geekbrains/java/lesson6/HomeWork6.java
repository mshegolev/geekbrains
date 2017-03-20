package geekbrains.java.lesson6;

import com.sun.istack.internal.NotNull;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by mikhail.shchegolev on 13.02.2017.
 */
public class HomeWork6 {
    private static String filename1 = "1.txt";
    private static String filename2 = "2.txt";
    private static String[] filenameList = {filename1, filename2};

    public static void main(String[] args) throws IOException {
        String text1 = createMyString(1);
        String text2 = createMyString(2);

        writeFile(filename1, text1);
        writeFile(filename2, text2);

        String s = readFile(filename1);
        writeFile(filename2, text2 + s);
    }

    public static void filerConcatinator(String file1, String file2) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;
        try {
            fin = new FileInputStream(file1);
            do {
                i = fin.read();
                if (i != -1) fout.write(i);
            } while (i != -1);

            if (fin != null) fin.close();
            if (fout != null) fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @NotNull
    private static String createMyString() {
        return createMyString(50);
    }

    @NotNull
    private static String createMyString(int stringLenght) {
        StringBuffer s = new StringBuffer();
        for (int j = 0; j < stringLenght; j++) {
            int gg = new Random().nextInt(100);
            s.append(gg);
            s.append(" ");
        }
        s.append(" end string.");
        return s.toString();
    }


    private static void writeFile(String filename2, String text) {
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(filename2);
            for (int i = 0; i < text.length(); i++) {
                fout.write(text.charAt(i));
            }
            if (fout != null) fout.close();
        } catch (IOException e) {
            System.out.println(new StringBuilder().append("File ").append(filename2).append(" is not read.").toString());
        }
    }

    private static String readFile(String filename1) {
        FileInputStream fin;
        int i;
        String s = new String();
        try {
            fin = new FileInputStream(filename1);
            do {
                i = fin.read();
                if (i != -1) s += (char) i;
            } while (i != -1);
            fin.close();
            s.toString();
        } catch (IOException e) {
            System.out.println(new StringBuilder().append("File ").append(filename1).append(" is not read.").toString());
        }
        return s.toString();
    }


}
