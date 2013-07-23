import java.util.Scanner;

public class Field extends Main{

    private static final char DEFAULT_CELL_VALUE = ' ';
    private static final char DEFAULT_FIELD_SIZE = 3;
    protected char mark = ' ';
    protected boolean win = false;

    Scanner scan = new Scanner(System.in);

    private final int fieldSize;

    protected char[][] field;

    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }

    public Field(int size) {
        fieldSize = size;
        field = new char[fieldSize][fieldSize];
    }

    public void eraseField() {
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

    /*
        Два switch, что бы не вводить координаты ячейки.
        Размышляю как вынести в метод внутреннюю проверку на определенной ячейки, в зависимости от case.
    */
    public void playerActionX() {
        System.out.println("Enter number for X:");
        int cellX = scan.nextInt();
        mark = 'X';
        switch (cellX) {
            case 1:
                if (field[0][0] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[0][0] = mark;
                }
                break;

            case 2:
                if (field[1][0] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[1][0] = mark;
                }
                break;

            case 3:
                if (field[2][0] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[2][0] = mark;
                }
                break;

            case 4:
                if (field[0][1] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[0][1] = mark;
                }
                break;

            case 5:
                if (field[1][1] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[1][1] = mark;
                }
                break;

            case 6:
                if (field[2][1] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[2][1] = mark;
                }
                break;

            case 7:
                if (field[0][2] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[0][2] = mark;
                }
                break;

            case 8:
                if (field[1][2] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[1][2] = mark;
                }
                break;

            case 9:
                if (field[2][2] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionX();
                } else {
                    field[2][2] = mark;
                }
                break;
        }
    }

    public void playerActionO() {
        System.out.println("Enter number for O:");
        int cellO = scan.nextInt();
        mark = 'O';
        switch (cellO) {
            case 1:
                if (field[0][0] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[0][0] = mark;
                }
                break;

            case 2:
                if (field[1][0] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[1][0] = mark;
                }
                break;

            case 3:
                if (field[2][0] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[2][0] = mark;
                }
                break;

            case 4:
                if (field[0][1] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[0][1] = mark;
                }
                break;

            case 5:
                if (field[1][1] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[1][1] = mark;
                }
                break;

            case 6:
                if (field[2][1] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[2][1] = mark;
                }
                break;

            case 7:
                if (field[0][2] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[0][2] = mark;
                }
                break;

            case 8:
                if (field[1][2] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[1][2] = mark;
                }
                break;

            case 9:
                if (field[2][2] != DEFAULT_CELL_VALUE) {
                    System.out.println("Error, try again!");
                    playerActionO();
                } else {
                    field[2][2] = mark;
                }
                break;
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
}



