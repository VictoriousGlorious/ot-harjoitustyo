package katja.budjetointisovellus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class AppLogic {

    private HashMap<String, User> users;
    private User signedInUser;

    public AppLogic() {
        this.users = new HashMap<>();
        
    }

    public void newUser(String id, String password) {
        User user = new User(id, password);
        this.users.put(id, user);
    }

    public boolean signIn(String id, String password) {
        if (!(users.containsKey(id))) {
            return false;
        }
        User user = users.get(id);
        if (user.getPassword().equals(password)) {
            signedInUser = user;
            return true;
        }

        return false;

    }

    public void signOut() {
        this.signedInUser = null;
    }
    
    public HashMap<String, User> getUsers() {
        return this.users;
    }
    

    public void actions() {

    }

    public User getSignedInUser() {
        return this.signedInUser;
    }

    public void newBudget(String name, double goal, Date start, Date end) {
        Budget budget = new Budget(name, goal, start, end);
        this.signedInUser.addBudget(budget);
    }

    public ArrayList<Budget> listBudgets() {
        return this.signedInUser.getBudgets();
    }

    public void newExpense() {

    }

    public void listIncome() {

    }

    public void listExpenses() {

    }

    public void listIncomes() {

    }

    public void listAll() {

    }

}
