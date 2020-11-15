package katja.budjetointisovellus;

import java.util.ArrayList;

public class User {

    private String id;
    private final String password;    
    private ArrayList<Transaction> transactions;
    private ArrayList<Budget> budgets;

    public User(String id, String password) {
        this.id = id;
        this.password = password;
        this.transactions = new ArrayList<>();
        this.budgets = new ArrayList<>();
        // this.transactions.add(new Transaction(TransactionType.INCOME, 20.0, '2', Date));
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    
    public void addBudget(Budget budget) {
        budgets.add(budget);
    }
    
    public int numberOfBudgets() {
        return this.budgets.size();
    }
    
    public ArrayList<Transaction> getTrancsactions() {
        return this.transactions;
    }
    
    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }
    
    @Override
    public String toString() {
        return "User: " + this.id;
    }
    
    

}
