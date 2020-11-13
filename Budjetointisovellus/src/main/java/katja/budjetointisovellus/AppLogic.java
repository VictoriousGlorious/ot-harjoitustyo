package katja.budjetointisovellus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class AppLogic {

    private ArrayList<User> users;
    private Scanner scanner;
    private boolean signedIn;
    private User user;

    public AppLogic(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        signedIn = false;
        this.users = new ArrayList<>();
        while (true) {
            System.out.println("Luo uusi tunnus: 1");
            System.out.println("Kirjaudu: 2");
            System.out.println("Lopeta: 3");
            System.out.println("---------------------------");
            String answer = scanner.nextLine();
            if (answer.equals("3")) {
                break;
            }
            if (answer.equals("1")) {
                newUser();
            }
            if (answer.equals("2")) {
                signIn();
                if (signedIn) {
                    break;
                }
            }

        }

    }

    public void newUser() {
        System.out.println("Anna uusi tunnus:");
        String id = scanner.nextLine();
        System.out.println("Anna salasana:");
        String password = scanner.nextLine();
        User user = new User(id, password);
        users.add(user);
        System.out.println("---------------------------");
        System.out.println("Uusi tunnus luoutu.");
        System.out.println("---------------------------");
        System.out.println("");
    }

    public void signIn() {
        while (true) {
            System.out.println("Syötä käyttäjätunnus: ");
            String id = scanner.nextLine();
            System.out.println("Syötä salasana:");
            String password = scanner.nextLine();
            for (User user : users) {
                if (user.getId().equals(id)) {
                    if (user.getPassword().equals(password)) {
                        System.out.println("---------------------------");
                        System.out.println("Tervetuloa!");
                        System.out.println("---------------------------");
                        System.out.println("");
                        signedIn = true;
                        this.user = user;
                        break;
                    }
                } else {
                    System.out.println("---------------------------");
                    System.out.println("Käyttäjätunnus tai salasana virheellinen.");
                    System.out.println("");
                }
            }
            if (users.isEmpty()) {
                System.out.println("---------------------------");
                System.out.println("Käyttäjätunnus tai salasana virheellinen.");
                System.out.println("");
            }
            break;

        }
    }

    public void actions() {
        while (true) {
            System.out.println("Hei " + this.user.getId() + ", mitä tehdään?");
            System.out.println("---------------------------");
            System.out.println("Budjetointi: 1");
            System.out.println("Kuluseuranta: 2");
            System.out.println("Lopeta: 3");

            String a = scanner.nextLine();
            if (a.equals("3")) {
                break;
            }
            if (a.equals("1")) {
                System.out.println("---------------------------");
                System.out.println("Luo uusi budjetti: 1");
                System.out.println("Listaa olemassaolevat budjetit: 2");
                System.out.println("---------------------------");

                String b = scanner.nextLine();
                if (b.equals("1")) {
                    newBudget();
                }
                if (b.equals("2")) {
                    listBudgets();
                }
            }
            if (a.equals("2")) {
                System.out.println("---------------------------");
                System.out.println("Luo uusi meno: 1");
                System.out.println("Luo uusi tulo: 2");
                System.out.println("Listaa menot: 3");
                System.out.println("Listaa tulot: 4");
                System.out.println("Listaa kaikki: 5");
                System.out.println("---------------------------");

                String b = scanner.nextLine();
                if (b.equals("1")) {
                    newExpense();
                }
                if (b.equals("2")) {
                    listIncome();
                }

                if (b.equals("3")) {
                    listExpenses();
                }
                if (b.equals("4")) {
                    listIncomes();
                }

                if (b.equals("5")) {
                    listAll();
                }
            }

        }

    }

    private void newBudget() {
        try {
            System.out.println("Nimi:");
            String name = scanner.nextLine();
            System.out.println("Tavoite:");
            double goal = Double.valueOf(scanner.nextLine());
            System.out.println("Aloituspäivämäärä (dd/MM/yyyy):");
            String date1 = scanner.nextLine();
            System.out.println("Lopetuspäivämäärä (dd/MM/yyyy):");
            String date2 = scanner.nextLine();
            SimpleDateFormat dateF = new SimpleDateFormat("dd/MM/yyyy");
            Date start = dateF.parse(date1);
            Date end = dateF.parse(date2);
            Budget budget = new Budget(name, goal, start, end);

            this.user.addBudget(budget);

        } catch (Exception e) {
            System.out.println("Tapahtui virhe: " + e.toString());
        }
    }

    private void listBudgets() {
        if (user.numberOfBudgets()== 0) {
            System.out.println("Sinulla ei ole vielä budjetteja.");
            return;           
        }
        user.getBudgets();
    }

    private void newExpense() {

    }

    private void listIncome() {

    }

    private void listExpenses() {

    }

    private void listIncomes() {

    }

    private void listAll() {

    }

}
