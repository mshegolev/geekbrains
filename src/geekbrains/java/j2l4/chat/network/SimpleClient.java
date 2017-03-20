package geekbrains.java.j2l4.chat.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by mikhail.shchegolev on 20.03.2017.
 */
public class SimpleClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1",8189)) {
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            out.write(255);
            int b = in.read();
            System.out.println("prinyali 1 " + b);
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
