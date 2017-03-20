package geekbrains.java.j2l4.chat.network;

import java.net.Socket;

/**
 * Created by mikhail.shchegolev on 20.03.2017.
 */
public interface SocketThreadListener {
    void onStartSocketThread(SocketThread socketThread, Socket socket);
    void onStopSocketThread(SocketThread socketThread, Socket socket);

    void onSocketIsReady(SocketThread socketThread, Socket socket);
    void onRecieveString(SocketThread socketThread, Socket socket, String msg);
}
