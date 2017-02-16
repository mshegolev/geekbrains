package geekbrains.java.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    int linesCount;
    final int PANEL_SIZE = 500;
    int CELL_SIZE;


    public Map(int linesCount) {
        this.linesCount = linesCount;
        CELL_SIZE = PANEL_SIZE / linesCount;
        setBackground(Color.white);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                System.out.println(e.getX() + " " + e.getY());
                System.out.println(e.getX() / CELL_SIZE + " " + e.getY() / CELL_SIZE);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= linesCount; i++) {
            g.drawLine(0, i * CELL_SIZE, PANEL_SIZE, i * CELL_SIZE);
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, PANEL_SIZE);
        }
    }
}
