package ru.geekbrains.chat.server.core;

import ru.geekbrains.chat.Cmd;
import ru.geekbrains.network.ServerSocketThread;
import ru.geekbrains.network.ServerSocketThreadListener;
import ru.geekbrains.network.SocketThread;
import ru.geekbrains.network.SocketThreadListener;

import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Vector;

public class ChatServer implements ServerSocketThreadListener, SocketThreadListener {

    private final Vector<SocketThread> clients = new Vector<>();
    private ServerSocketThread serverSocketThread;

    public void start(int port) {
        if (serverSocketThread != null && serverSocketThread.isAlive()) {
            System.out.println("Сервер уже запущен.");
            return;
        }
        serverSocketThread = new ServerSocketThread("ServerSocketThread", this, port, 3000);
        SQLClient.connect();
        System.out.println("nick = " + SQLClient.getNick("login_1", "pass1"));
    }

    public void stop() {
        if (serverSocketThread == null || !serverSocketThread.isAlive()) {
            System.out.println("Сервер не запущен.");
            return;
        }
        serverSocketThread.interrupt();
        SQLClient.disconnect();
    }

    //События ServerSocketThread в потоке ServerSocketThread
    @Override
    public void onStartServerThread(ServerSocketThread thread) {
        putLog(thread, "started.");
    }

    @Override
    public void onStopServerThread(ServerSocketThread thread) {
        putLog(thread, "stopped.");
    }

    @Override
    public void onCreateServerSocket(ServerSocketThread thread, ServerSocket serverSocket) {
        putLog(thread, "onCreateServerSocket");
    }

    @Override
    public void onAcceptedSocket(ServerSocketThread thread, Socket socket) {
        putLog(thread, "Client connected: " + socket);
        String threadName = "Socket thread: " + socket.getInetAddress() + ":" + socket.getPort();
        new ChatSocketThread(threadName, this, socket);
    }

    @Override
    public void onTimeOutSocket(ServerSocketThread thread, ServerSocket serverSocket) {
//        putLog(thread, "onTimeOutSocket");
    }

    private synchronized void putLog(Thread thread, String msg) {
        System.out.println(thread.getName() + ": " + msg);
    }

    //События SocketThread'ов в соответствующих потоках
    @Override
    public synchronized void onStartSocketThread(SocketThread socketThread, Socket socket) {
        putLog(socketThread, "started.");
    }

    @Override
    public synchronized void onStopSocketThread(SocketThread socketThread, Socket socket) {
        putLog(socketThread, "stopped.");
        ChatSocketThread client = (ChatSocketThread) socketThread;
        clients.remove(client);
        if (client.authorized()) {
            sendBroadCastMsg(client.getNick() + ": disconnected", true,true);
        }
    }

    @Override
    public synchronized void onSocketIsReady(SocketThread socketThread, Socket socket) {
        putLog(socketThread, "onSocketIsReady");
        clients.add(socketThread);
    }

    @Override
    public synchronized void onReceiveString(SocketThread socketThread, Socket socket, String value) {
        ChatSocketThread client = (ChatSocketThread) socketThread;
        if (!client.authorized()) {
            handleNonAuthorizedMsg(client, value);
            return;
        }
        sendBroadCastMsg(value, true,true);
    }

    private void handleNonAuthorizedMsg(ChatSocketThread client, String value) {
        String[] arr = value.split(Cmd.DELIMITER);
        if (arr.length != 3 || !arr[0].equals(Cmd.AUTH)) {
            client.sendMsg("Authorization message format error.");
            client.close();
            return;
        }
        String nick = SQLClient.getNick(arr[1], arr[2]);
        if (nick == null) {
            client.sendMsg("Incorrect login/password.");
            client.close();
            return;
        }
        client.setNick(nick);
        client.setAuthorized(true);
        sendBroadCastMsg(nick + ": connected", true,true);
    }


    private String getTime() {
        LocalDate localDate = LocalDate.now();
        StringBuilder msg = new StringBuilder();
        return msg.append(localDate.toString()).append(": ").toString();
    }

    private void sendBroadCastMsg(String msg, boolean addTime, boolean addNick) {
        for (int i = 0; i < clients.size(); i++) {

            ChatSocketThread client = (ChatSocketThread) clients.get(i);
            if (addTime) {msg = getTime()+ msg;}
            if (addNick){msg = client.getNick()+ msg;}
            if (client.authorized()) client.sendMsg(msg);
        }
    }

    @Override
    public synchronized void onException(SocketThread socketThread, Socket socket, Exception e) {
        e.printStackTrace();
    }
}
