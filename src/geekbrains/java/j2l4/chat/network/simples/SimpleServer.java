package geekbrains.java.j2l4.chat.network.simples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mikhail.shchegolev on 20.03.2017.
 */
public class SimpleServer {
    public static void main(String[] args) {
        try (   ServerSocket serverSocket = new ServerSocket(8189);
                Socket socket = serverSocket.accept()
        ) {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            while (true)out.writeUTF("echo: " +in.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    ///////////////
}

