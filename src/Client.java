import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Field {
    public void client() {

        Server serv = new Server();
        Menu menu = new Menu();
        Scanner scan = new Scanner(System.in);


        System.out.println("Welcome to Client side");

        Socket fromserver = null;

        System.out.println("Connecting to... ");
        Field field = new Field();
        field.newField();


        try {
            String server = "192.168.0.71";
            System.out.println("Enter Server IP:");
//            String server = scan.nextLine();
            fromserver = new Socket(server,5500);
            BufferedReader in  = new BufferedReader(new InputStreamReader(fromserver.getInputStream()));
            PrintWriter out = new PrintWriter(fromserver.getOutputStream(),true);
            BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

            String fuser, fserver;
            System.out.println("Numbers of cells: \n[1][2][3]\n[4][5][6]\n[7][8][9]");
            System.out.println("Wait for X step!..");
            while (loop == 1) {
                System.out.println("Start loop");

                fserver = in.readLine();
                cellNumber = Integer.parseInt(fserver);
                System.out.println("Step X: " + cellNumber);
//                this.mark = 'X';
                field.actionX(cellNumber);
                field.showField();
                field.checkWin(mark);
                if (field.win) break;

                System.out.println("Your step: ");
                //
                mark = 'O';
                do {
//                    fuser = inu.readLine();
//                    cellNumber = Integer.parseInt(fuser);
                    this.cellNumber = scan.nextInt();

                    count = 1;

                    for (int i = 0; i < DEFAULT_FIELD_SIZE; i++) {
                        for (int j = 0; j < DEFAULT_FIELD_SIZE; j++) {
                            if (count == cellNumber) {
                                if(field.field[j][i] != DEFAULT_CELL_VALUE) {
                                    System.out.println("Input error! Try again!");
                                    cellNumber = 0;
                                } else {
                                    field.field[j][i] = mark;
                                    out.println(cellNumber);
                                }
                            }
                            count++;
                        }
                    }
                } while (cellNumber == 0);
                System.out.println(win);
                //


                field.showField();
                field.checkWin(mark);
                if (field.win) break;

//                fuser = inu.readLine();
//                cellNumber = Integer.parseInt(fuser);
//                field.actionO(cellNumber);
//
//                out.println(cellNumber);
//
//                field.showField();
//                field.checkWin(field.mark);
//                if (field.win) break;
            }
            menu.endGame();

//            out.close();
//            in.close();
//            inu.close();
//            fromserver.close();
        } catch (IOException e) {
//            System.out.println(e);

        }
    }
}
