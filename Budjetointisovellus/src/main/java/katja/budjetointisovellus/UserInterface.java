package katja.budjetointisovellus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserInterface {

    private AppLogic app;
    private Scanner scanner;

    public UserInterface(Scanner scanner, AppLogic app) {
        this.scanner = scanner;
        this.app = app;
    }

    public void start() {
        System.out.println("-------------------------");
        System.out.println("Tervetuloa budjetointisovellukseen!");
        System.out.println("-------------------------");
        System.out.println("");

        while (true) {
            System.out.println("Valitse toiminto:");
            System.out.println("Luo uusi tunnus: 1");
            System.out.println("Kirjaudu: 2");
            System.out.println("Lopeta: 3");
            System.out.println("-------------------------");
            String answer = scanner.nextLine();

            if (answer.equals("3")) {
                break;
            }
            if (answer.equals("1")) {
                newUser();
            }
            if (answer.equals("2")) {
                boolean success = signIn();
                if (success) {
                    actions();
                }
            }

        }

    }

    public void newUser() {
        System.out.println("-------------------------");
        System.out.println("Syötä käyttäjätunnus:");
        String id = scanner.nextLine();
        System.out.println("Syötä salasana:");
        String password = scanner.nextLine();
        app.newUser(id, password);
        System.out.println("-------------------------");
        System.out.println("Uusi käyttäjätunnus " + id + " luotu.");
        System.out.println("-------------------------");
    }

    public boolean signIn() {
        System.out.println("-------------------------");
        System.out.println("Anna käyttäjätunnus:");
        String id = scanner.nextLine();
        System.out.println("Anna salasana:");
        String password = scanner.nextLine();
        boolean signedIn = app.signIn(id, password);
        if (signedIn) {
            System.out.println("-------------------------");
            System.out.println(id + ", olet kirjautunut sisään.");
            System.out.println("-------------------------");
            return true;

        } else {
            System.out.println("-------------------------");
            System.out.println("Käyttäjätunnus tai salasana väärin.");
            System.out.println("-------------------------");
            return false;
        }
    }

    public void actions() {
        System.out.println("Hei " + app.getSignedInUser().getId() + ", mitä tehdään?");
        System.out.println("-------------------------");

        while (true) {
            System.out.println("Budjetointi: 1");
            System.out.println("Tapahtumien syöttö: 2");
            System.out.println("Kirjaudu ulos: 3");
            String answer = scanner.nextLine();
            if (answer.equals("3")) {
                app.signOut();
                return;
            }
            if (answer.equals("1")) {
                budgetActions();
            }

            if (answer.equals("2")) {
                transactionActions();
            }
        }

    }

    public void budgetActions() {
        while (true) {
            System.out.println("-------------------------");
            System.out.println("Luo uusi budjetti: 1");
            System.out.println("Listaa omat budjetit: 2");
            System.out.println("Palaa edelliseen valikkoon: 3");
            String answer = scanner.nextLine();
            if (answer.equals("3")) {
                return;
            }
            if (answer.equals("1")) {
                System.out.println("Budjetin nimi: ");
                String name = scanner.nextLine();
                System.out.println("Tavoite:");
                double goal = Double.valueOf(scanner.nextLine());
                System.out.println("Aloituspäivämäärä (dd.MM.yyyy):");
                String date1 = scanner.nextLine();
                System.out.println("Lopetuspäivämäärä (dd.MM.yyyy):");
                String date2 = scanner.nextLine();
                Date start;
                try {
                    start = new SimpleDateFormat("dd.MM.yyyy").parse(date1);
                    Date end = new SimpleDateFormat("dd.MM.yyyy").parse(date2);
                    app.newBudget(name, goal, start, end);
                } catch (ParseException ex) {
                    Logger.getLogger(UserInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (answer.equals("2")) {
                ArrayList<Budget> budgets = app.listBudgets();
                if (budgets == null) {
                    System.out.println("Sinulla ei ole luotuja budjetteja.");
                } else {
                    budgets.stream().forEach(b -> System.out.println(b));
                }
            }

        }
    }

    public void transactionActions() {

    }

}
