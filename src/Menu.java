import java.util.Scanner;

public class Menu {
    Field field = new Field();
    Server server = new Server();
    Client client = new Client();

    Scanner scan = new Scanner(System.in);

    private int cellNumber;

    public void newGame() {
        System.out.println("What are you want now? \n1. I-net Game \n2. Game on the same PC \n3. Game against AI \nEnter mode No.");
        int mode = scan.nextInt();
        switch (mode) {
            case 1:
                internetGame();
                break;
            case 2:
                onePCGame();
                break;
            case 3:
                againstAI();
                break;
        }
        if (mode > 3 || mode < 1) {
            System.out.println("Wrong input");
            newGame();
        }
    }

    public void againstAI() {
        System.out.println("Numbers of cells: \n[1][2][3]\n[4][5][6]\n[7][8][9]");
        field.newField();
        while (true) {
            System.out.println("Enter number for X:");

            cellNumber = scan.nextInt();
            field.actionX(cellNumber);
            field.showField();

            field.checkWin(field.mark);

            if (field.win) break;

            field.actionAI();
            field.checkWin(field.mark);
            field.showField();

            field.checkWin(field.mark);

            if (field.win) break;
        }
        endGame();
    }

    public void internetGame() {
        System.out.println("If you wanna be Server enter 1, for Client - other numbers");
        int x = scan.nextInt();
        if(x == 1) {
            server.server();
        } else {
            client.client();
        }
        endGame();
    }

    public void endGame() {
        System.out.println("One more game? 1. Yes 2. No");
        int x = scan.nextInt();
        if (x == 1) {
            newGame();
        } else {
            System.out.println("Good luck!");

        }
    }

    public void onePCGame() {
        System.out.println("Numbers of cells: \n[1][2][3]\n[4][5][6]\n[7][8][9]");
        field.newField();

        while (true) {
            System.out.println("Enter number for X:");
            cellNumber = scan.nextInt();
            field.actionX(cellNumber);
            field.showField();

            field.checkWin(field.mark);

            if (field.win) break;

            System.out.println("Enter number for O:");
            cellNumber = scan.nextInt();
            field.actionO(cellNumber);
            field.showField();

            field.checkWin(field.mark);

            if (field.win) break;
        }
        endGame();
    }
}
