package geekbrains.java.j2l4.chat.network;

/**
 * Created by myname on 16.03.17.
 */
public class ServerSocketThread extends Thread {
    public ServerSocketThread(String name) {
        super(name);
        start();
    }

    @Override
    public void run()
    {
        System.out.println("server running!");
        while (!isInterrupted()) {
            System.out.println("Thread is work: " + getName());
            try{
                sleep(3000);
            }catch (InterruptedException e ){
                System.out.println("sleep prervan interrapted");
                break;
            }
        }

    }

}
