package geekbrains.java.j2l4.chat.network.simples;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by mikhail.shchegolev on 20.03.2017.
 */
public class SimpleClient {
    public static void main(String[] args) {
        try(Socket socket = new Socket("127.0.0.1",8189)) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            while (true) {
                out.writeUTF(scanner.nextLine());
                System.out.println(in.readUTF());
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
