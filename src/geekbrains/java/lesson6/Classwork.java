package geekbrains.java.lesson6;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by mikhail on 09.02.2017.
 */
public class Classwork {
    public static void methodA() {
        RuntimeException re = new RuntimeException("Message");
        throw re;
    }

    public static void main(String[] args) {
        //methodA();
        InputStream is;
        OutputStream os;
        String s ;

        try {
            FileInputStream fis = new FileInputStream("test.txt");
            int r;
            do {
                r=fis.read();
                System.out.print(r);
            } while(r!=-1);
            //System.out.println((char)fis.read());
            fis.close();

//            FileOutputStream fos = new FileOutputStream("test.txt",true);
//            String  s = "H";
//            fos.write(s.getBytes());
//            fos.flush();
//            fos.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
