package geekbrains.java.j2l4.chat.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by mikhail.shchegolev on 20.03.2017.
 */
public class SocketThread extends Thread {
    private Socket socket;
    private SocketThreadListener eventListener;
    private DataOutputStream out;

    public SocketThread(String name, Socket socket) {
        super(name);
        this.socket = socket;
        this.eventListener = eventListener;
        start();
    }

    @Override
    public void run() {
        try {
            eventListener.onStartSocketThread(this, socket);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            eventListener.onSocketIsReady(this, socket);
            while (!isInterrupted()) {
                String msg = in.readUTF();
                eventListener.onRecieveString(this, socket, msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            eventListener.onStopSocketThread(this, socket);
        }
    }
    public synchronized boolean sendMsg(String msg){
        try {
            out.writeUTF(msg);
            out.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            close();
            return false;
        }
    }

    private synchronized void close(){
        interrupt();
        try{
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
