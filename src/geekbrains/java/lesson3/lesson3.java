package geekbrains.java.lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by mikhail.shchegolev on 06.02.2017.
 */
public class lesson3 {

    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '.';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static int toWin;
    private static char[][] field;

    // Инициализация игрового поля с заданием размеров и "выигрышной длины"
    private static void initMap(int size_y, int size_x, int winLength) {
        fieldSizeY = size_y;
        fieldSizeX = size_x;
        toWin = winLength;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }
    // Вывели поле с любыми украшениями вокруг него
    private static void printMap() {
        System.out.print("+ ");
        for (int i = 1; i <= fieldSizeX; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < fieldSizeY; i++) {
            System.out.print(i + 1 + "|");
            for (int j = 0; j < fieldSizeX; j++) System.out.print(field[i][j] + "|");
            System.out.println();
            System.out.println(new String(new char[fieldSizeX * 2 + 2]).replace('\0', '-'));
        }
        System.out.println();
    }
    // Ход игрока
    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты X и Y через пробел>> ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));
        field[y][x] = HUMAN_DOT;
    }
    // Ход компьютера
    private static void aiTurn() {
        if(turnAIWinCell()) return;		// проверим, не выиграет-ли игрок на следующем ходу
        if(turnHumanWinCell()) return;	// проверим, не выиграет-ли комп на следующем ходу
        int x, y;
        do {							// или комп ходит в случайную клетку
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }
    // Проверка, может ли выиграть комп
    private static boolean turnAIWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {				// поставим нолик в каждую клетку поля по очереди
                    field[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)) return true;	// если мы выиграли, вернём истину, оставив нолик в выигрышной позиции
                    field[i][j] = EMPTY_DOT;			// если нет - вернём обратно пустоту в клетку и пойдём дальше
                }
            }
        }
        return false;
    }
    // Проверка, выиграет-ли игрок своим следующим ходом
    private static boolean turnHumanWinCell() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isEmptyCell(j, i)) {
                    field[i][j] = HUMAN_DOT;			// поставим крестик в каждую клетку по очереди
                    if (checkWin(HUMAN_DOT)) {			// если игрок победит
                        field[i][j] = AI_DOT;			// поставить на то место нолик
                        return true;
                    }
                    field[i][j] = EMPTY_DOT;			// в противном случае вернуть на место пустоту
                }
            }
        }
        return false;
    }
    // проверка на победу
    private static boolean checkWin(char c) {
        for (int i = 0; i < fieldSizeX; i++) {			// ползём по всему полю
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, toWin, c)) return true;	// проверим линию по х
                if (checkLine(i, j, 1, 1, toWin, c)) return true;	// проверим по диагонали х у
                if (checkLine(i, j, 0, 1, toWin, c)) return true;	// проверим линию по у
                if (checkLine(i, j, 1, -1, toWin, c)) return true;	// проверим по диагонали х -у
            }
        }
        return false;
    }
    // проверка линии
    private static boolean checkLine(int x, int y, int vx, int vy, int len, char c) {
        final int far_x = x + (len - 1) * vx;			// посчитаем конец проверяемой линии
        final int far_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, far_y)) return false;	// проверим не выйдет-ли проверяемая линия за пределы поля
        for (int i = 0; i < len; i++) {					// ползём по проверяемой линии
            if (field[y + i * vy][x + i * vx] != c) return false;	// проверим одинаковые-ли символы в ячейках
        }
        return true;
    }
    // ничья?
    private static boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
    // ячейка-то вообще правильная?
    private static boolean isValidCell(int x, int y) { return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY; }
    // а пустая?
    private static boolean isEmptyCell(int x, int y) { return field[y][x] == EMPTY_DOT; }
    // ну, поиграем))
    public static void main(String[] args) {
        initMap(5, 5, 3);
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Выиграл игрок!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(AI_DOT)) {
                System.out.println("Выиграл компьютер!!!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!!!");
                break;
            }
        }
        scanner.close();
    }
}
