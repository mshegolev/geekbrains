package geekbrains.java.lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    private int fieldSizeY;
    private int fieldSizeX;
    final int PANEL_SIZE = 500;
    private final Random random = new Random();
    int linesCount;
    int CELL_SIZE;

    int field;
    int winLenght;
    int cellWigth;
    int cellHight;

    int EMPTY_DOT = 0;
    int HUMAN_DOT = 1;
    int AI_DOT = 2;

    boolean initialized = false;
    private int toWin;



    public Map(int WEIGHT, int HEIGHT) {
        this.linesCount = WEIGHT;
        CELL_SIZE = PANEL_SIZE / HEIGHT;
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

    void update(MouseEvent e) {
        int cellX = e.getX() / cellWigth;
        int cellY = e.getY() / cellHight;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i <= linesCount; i++) {
            g.drawLine(0, i * CELL_SIZE, PANEL_SIZE, i * CELL_SIZE);
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, PANEL_SIZE);
        }
    }

    // Инициализация игрового поля с заданием размеров и "выигрышной длины"
    private void initMap(int size_y, int size_x, int winLength) {
        fieldSizeY = size_y;
        fieldSizeX = size_x;
        toWin = winLength;
        //field = field[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
          //      field[i][j] = EMPTY_DOT;
            }
        }
    }

    // Вывели поле с любыми украшениями вокруг него
    private void printMap() {
        System.out.print("+ ");
        for (int i = 1; i <= fieldSizeX; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) System.out.print("gg");
            System.out.println();
            System.out.println(new String(new char[fieldSizeX * 2 + 2]).replace('\0', '-'));
        }
        System.out.println();
    }
}





