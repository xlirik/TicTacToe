import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;


public class Field {

    protected static final char DEFAULT_CELL_VALUE = ' ';
    protected static final char DEFAULT_FIELD_SIZE = 3;
    protected int loop = 1;
    protected char mark = ' ';
    protected boolean win = false;
<<<<<<< HEAD
    protected int count = 1;
    protected int cellNumber = 0;
=======
    private int count = 1;
>>>>>>> b0617aecbb6e45aebdf1966ad24d0052496e09e5

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();



    protected final int fieldSize;

    protected char[][] field;

    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size) {
        fieldSize = size;
        field = new char[fieldSize][fieldSize];
    }

    public void newField() {
        for (int i = 0; i < fieldSize; i++) {
            eraseLine(i);
        }
    }

    public void showField() {
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            showLine(i);
        }
    }

    private void eraseLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            field[i][lineNumber] = DEFAULT_CELL_VALUE;
        }
    }

    private void showLine(int lineNumber) {
        for (int i = 0; i < fieldSize; i++) {
            showCell(i, lineNumber);
        }
        System.out.println();
    }

    private void showCell(int x, int y) {
        System.out.print("[" + field[x][y] + "]");
    }

<<<<<<< HEAD
    public void actionX(int cellNumber) {
        if(cellNumber == 0) {
            cellNumber = scan.nextInt();
        }
=======
    public void playerActionX() {
        System.out.println("Enter number for X:");
        int cellNumber = scan.nextInt();
>>>>>>> b0617aecbb6e45aebdf1966ad24d0052496e09e5
        count = 1;
        mark = 'X';
        for (int i = 0; i < DEFAULT_FIELD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_FIELD_SIZE; j++) {
                if (count == cellNumber) {
                    if(field[j][i] != DEFAULT_CELL_VALUE) {
<<<<<<< HEAD
                        cellNumber = 0;
                        actionX(cellNumber);
=======
                        System.out.println("Input error");
                        playerActionX();
>>>>>>> b0617aecbb6e45aebdf1966ad24d0052496e09e5
                    } else {
                        field[j][i] = mark;
                    }
                }
                count++;
            }
<<<<<<< HEAD
        }
    }

    public void actionO(int cellNumber) {
        if(cellNumber == 0) {
            cellNumber = scan.nextInt();
        }
=======

        }
    }

    public void playerActionO() {
        System.out.println("Enter number for O:");
        int cellNumber = scan.nextInt();
>>>>>>> b0617aecbb6e45aebdf1966ad24d0052496e09e5
        count = 1;
        mark = 'O';
        for (int i = 0; i < DEFAULT_FIELD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_FIELD_SIZE; j++) {
                if (count == cellNumber) {
                    if(field[j][i] != DEFAULT_CELL_VALUE) {
<<<<<<< HEAD
                        cellNumber = 0;
                        actionO(cellNumber);
=======
                        System.out.println("Input error");
                        playerActionO();
>>>>>>> b0617aecbb6e45aebdf1966ad24d0052496e09e5
                    } else {
                        field[j][i] = mark;
                    }
                }
                count++;
            }
<<<<<<< HEAD
        }
    }

    public void actionAI() {
        cellNumber = rand.nextInt(9) + 1;
        count = 1;
        mark = 'O';
        for (int i = 0; i < DEFAULT_FIELD_SIZE; i++) {
            for (int j = 0; j < DEFAULT_FIELD_SIZE; j++) {
                if (count == cellNumber) {
                    if(field[j][i] != DEFAULT_CELL_VALUE) {
                        actionAI();
                    } else {
                        System.out.println("AI step: " + cellNumber);
                        field[j][i] = mark;
                    }
                }
                count++;
            }
=======
>>>>>>> b0617aecbb6e45aebdf1966ad24d0052496e09e5
        }
    }

    public void checkWin(char mark) {
        for (int i = 0; i < DEFAULT_FIELD_SIZE; i++) {
            if(field[0][i] == field[1][i] && field[1][i] == field[2][i] && field[2][i] == mark) {
                this.win = true;
            }

            if(field[i][0] == field[i][1] && field[i][1] == field[i][2] && field[i][2] == mark) {
                this.win = true;
            }

            if((field[0][0] == field[1][1] && field[1][1] == field[2][2] && field[2][2] == mark) ||
               (field[2][0] == field[1][1] && field[1][1] == field[0][2] && field[0][2] == mark)) {
                this.win = true;
            }

            if(win) {
                System.out.println(mark + " - win!");
                break;
            }
        }
    }

    public void checkDraw() {

    }
}
