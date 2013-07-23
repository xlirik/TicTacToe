import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Field field = new Field();
        Scanner scan = new Scanner(System.in);
        field.eraseField();

        System.out.println("Numbers of cells: \n[1][2][3]\n[4][5][6]\n[7][8][9]");

        while (true) {

            field.playerActionX();
            field.showField();

            field.checkWin(field.mark);

            if (field.win) break;

            field.playerActionO();
            field.showField();

            field.checkWin(field.mark);

            if (field.win) break;
        }
    }
}



