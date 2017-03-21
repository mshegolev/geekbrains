package geekbrains.java.j2l4.chat.server.core;

import geekbrains.java.j2l4.chat.network.ServerSocketThread;
import geekbrains.java.j2l4.chat.network.ServerSocketThreadListener;
import geekbrains.java.j2l4.chat.network.SocketThread;
import geekbrains.java.j2l4.chat.network.SocketThreadListener;

import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer implements ServerSocketThreadListener,SocketThreadListener {
    private ServerSocketThread serverSocketThread;

    public void start(int port) {
        if (serverSocketThread != null && serverSocketThread.isAlive()) {
            System.out.println("Сервер уже запущен.");
            return;
        }
        serverSocketThread = new ServerSocketThread("ServerSocketThread", this, port, 3000);
    }

    public void stop() {
        if (serverSocketThread == null || !serverSocketThread.isAlive()) {
            System.out.println("Сервер не запущен.");
            return;
        }
        serverSocketThread.interrupt();
    }


    void puLog(Thread thread, String msg) {
        System.out.println(thread.getName() + ":" + msg);
    }


    @Override
    public void onStartSocketThread(SocketThread socketThread, Socket socket) {

    }

    @Override
    public void onStopSocketThread(SocketThread socketThread, Socket socket) {

    }

    @Override
    public void onSocketIsReady(SocketThread socketThread, Socket socket) {

    }

    @Override
    public void onStartServerThread(ServerSocketThread thread, Socket socket) {
        puLog(thread, "onStartServerThread");
    }

    @Override
    public void onStopServerThread(ServerSocketThread thread, Socket socket) {

    }

    @Override
    public void onStopServerThread(ServerSocketThread thread) {
        puLog(thread, "onStopServerThread");
    }

    @Override
    public void onCreateServerSocket(ServerSocketThread thread, ServerSocket serverSocket) {
        puLog(thread, "onStopServerThread");
    }

    @Override
    public void onAcceptedSocket(ServerSocketThread thread, Socket socket) {
        puLog(thread,"Client connected: " + socket.toString());
        String threadName = "Socket thred: " + socket.getInetAddress() + ":"+socket.getPort();
        new SocketThread(threadName,socket);
    }

    @Override
    public void onTimeOutSocket(ServerSocketThread thread, ServerSocket serverSocket) {

    }

    @Override
    public void onRecieveString(SocketThread socketThread, Socket socket, String value) {
        socketThread.sendMsg(value);
    }
}
