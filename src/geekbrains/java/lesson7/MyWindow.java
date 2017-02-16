package geekbrains.java.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    public MyWindow() {
        setSize(507, 555);
        setResizable(false);
        setLocation(800, 200);
        setTitle("Simple Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Map jpMap = new Map(5);
        JPanel jpBottom = new JPanel(new GridLayout());
        jpBottom.setBackground(new Color(0, 0, 255));
        add(jpBottom, BorderLayout.SOUTH);
        add(jpMap, BorderLayout.CENTER);


        JButton jbStart = new JButton("Start New Game");
        JButton jbExit = new JButton("Exit Game");
        jpBottom.add(jbStart);
        jpBottom.add(jbExit);
        jbExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);

    }
}
