package geekbrains.java.j2l4.chat.network;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by mikhail.shchegolev on 20.03.2017.
 */
public interface ServerSocketThreadListener {
    void onStartServerThread(ServerSocketThread thread,Socket socket);

    void onStopServerThread(ServerSocketThread thread,Socket socket);

    void onStopServerThread(ServerSocketThread thread);

    void onCreateServerSocket(ServerSocketThread thread, ServerSocket serverSocket);

    void onAcceptedSocket(ServerSocketThread thread, Socket socket);

    void onTimeOutSocket(ServerSocketThread thread, ServerSocket serverSocket);

    void onRecieveString(SocketThread socketThread, Socket socket, String value);
}
