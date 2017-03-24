package geekbrains.java.j2l4.chat.network;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerSocketThread extends Thread {
    private ServerSocketThreadListener eventListener;
    private int port;
    private int timeout;


    public ServerSocketThread(String name,ServerSocketThreadListener eventListener, int port,int timeout) {
        super(name);
        this.eventListener=eventListener;
        this.port = port;
        this.timeout = timeout;

        start();
    }

    @Override
    public void run() {
        Socket socket = null;
        eventListener.onStartServerThread(this, socket);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            serverSocket.setSoTimeout(timeout);
            eventListener.onCreateServerSocket(this, serverSocket);
            while (!isInterrupted()) {
                try {
                    socket = serverSocket.accept();
                } catch (SocketTimeoutException e) {
                    eventListener.onTimeOutSocket(this, serverSocket);
                    continue;
                }
                eventListener.onAcceptedSocket(this, socket);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            eventListener.onStopServerThread(this);
        }
    }
}


