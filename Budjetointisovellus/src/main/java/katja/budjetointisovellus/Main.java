package katja.budjetointisovellus;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AppLogic app = new AppLogic(scanner);
        app.start();
        app.actions();

    }
}
