package geekbrains.java.j2l4.chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ClientGUI extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ClientGUI();
            }
        });
    }

    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 300;
    private static final String TITLE = "Chat client";

    private final JTextArea log = new JTextArea();

    private final JPanel upperPanel = new JPanel(new GridLayout(2, 3));
    private final JTextField fieldIPAddr = new JTextField("127.0.0.1");
    private final JTextField fieldPort = new JTextField("8189");
    private final JCheckBox chkAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField fieldLogin = new JTextField("login");
    private final JPasswordField fieldPass = new JPasswordField("123");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel bottomPanel = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("Disconnect");
    private final JTextField fieldInput = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private final JList<String> usersList = new JList<>();

    private ClientGUI(){
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(TITLE);
        setLocationRelativeTo(null);
        setResizable(false);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog, BorderLayout.CENTER);

        btnLogin.addActionListener(this);
        chkAlwaysOnTop.addActionListener(this);

        btnSend.addActionListener(this);
        fieldInput.addActionListener(this);
//
//        fieldInput.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//
//            }
//            @Override
//            public void keyReleased(KeyEvent e) {
//
//            }
//            @Override
//            public void keyTyped(KeyEvent e) {
//
//            }
//        });



        upperPanel.add(fieldIPAddr);
        upperPanel.add(fieldPort);
        upperPanel.add(chkAlwaysOnTop);
        upperPanel.add(fieldLogin);
        upperPanel.add(fieldPass);
        upperPanel.add(btnLogin);
        add(upperPanel, BorderLayout.NORTH);

        bottomPanel.add(btnDisconnect, BorderLayout.WEST);
        bottomPanel.add(fieldInput, BorderLayout.CENTER);
        bottomPanel.add(btnSend, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        JScrollPane scrollUsers = new JScrollPane(usersList);
        scrollUsers.setPreferredSize(new Dimension(150, 0));
        add(scrollUsers, BorderLayout.EAST);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if(src == chkAlwaysOnTop) {
            setAlwaysOnTop(chkAlwaysOnTop.isSelected());
        } else if(src == btnLogin){
            throw new RuntimeException("Всё пропало!!!");
        } else if(src == btnSend){
            try {
                PrintWriter pw = new PrintWriter(new FileWriter("chat.log"));
                pw.append(fieldInput.getText());
                log.append(fieldInput.getText() + "\n");
                pw.close();
                fieldInput.setText("");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //throw new RuntimeException("Всё пропало!!!");
        } else {
            throw new RuntimeException("Неизвестный src = " + src);
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        StackTraceElement[] stackTraceElements = e.getStackTrace();
        String msg;
        if(stackTraceElements.length == 0){
            msg = "Пустой StackTrace";
        } else {
            msg = e.getClass().getCanonicalName() + ": " + e.getMessage() + "\n" +
                    stackTraceElements[0].toString();
        }
        JOptionPane.showMessageDialog(null, msg, "Exception: ", JOptionPane.ERROR_MESSAGE);
        System.exit(1);
    }
}
