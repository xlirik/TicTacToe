import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Field{
    public void server() {
        Field field = new Field();
        field.newField();
        System.out.println("Welcome to Server side");
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner scan = new Scanner(System.in);
        BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));

        ServerSocket servers = null;
        Socket fromclient = null;

        // create server socket
        try {
            servers = new ServerSocket(5500);
            InetAddress local = InetAddress.getLocalHost();
            System.out.println(local.getHostAddress());
        } catch (IOException e) {
            System.out.println("Couldn't listen to port 5500");
            System.exit(-1);
        }

        try {
            System.out.print("Waiting for a client...");
            fromclient = servers.accept();
            System.out.println("Client connected");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(-1);
        }
        try {
            in  = new BufferedReader(new InputStreamReader(fromclient.getInputStream()));
            out = new PrintWriter(fromclient.getOutputStream(),true);
            String input, output;
            System.out.println("Numbers of cells: \n[1][2][3]\n[4][5][6]\n[7][8][9]");

            while (loop == 1) {

                System.out.println("Your step: ");

                //
                mark = 'X';
                do {
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
                                    checkWin(mark);
                                }
                            }
                            count++;
                        }
                    }
                } while (cellNumber == 0);
                //
//                int cellNumber = scan.nextInt();
//
//                field.actionX(cellNumber);

//                out.println(cellNumber);


                field.showField();
                field.checkWin(mark);
                if (field.win) break;

                input = in.readLine();
                cellNumber = Integer.parseInt(input);
                field.actionO(cellNumber);
                System.out.println("Step O: " + cellNumber);
                field.showField();
                field.checkWin(field.mark);
                if (field.win) break;

                System.out.println();
                if (input.equalsIgnoreCase("exit")) break;

            }


            out.close();
            in.close();
            fromclient.close();
            servers.close();
        } catch (IOException e) {

        }
    }
}
