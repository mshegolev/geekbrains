package geekbrains.java.j2l4.chat.server.core;

import geekbrains.java.j2l4.chat.network.ServerSocketThread;

public class ChatServer {

    public void start(int port){
        if(serverSocketThread != null && serverSocketThread.isAlive()) {
            System.out.println("server now is running");
        }
        serverSocketThread = new ServerSocketThread("ServerSocketThread");
    }

    private ServerSocketThread serverSocketThread;

    public void stop() {
        if (serverSocketThread == null || !serverSocketThread.isAlive()){
            System.out.println("Server don't run");
        return;
    }
        serverSocketThread.interrupt();
    }
}
