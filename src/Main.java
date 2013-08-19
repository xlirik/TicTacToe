import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Field field = new Field();
        Scanner scan = new Scanner(System.in);
        Server server = new Server();
        Client client = new Client();
        Menu menu = new Menu();

        field.newField();

        menu.newGame();

    }
}



