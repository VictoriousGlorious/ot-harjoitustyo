
package katja.budjetointisovellus;

import java.util.Date;

enum TransactionType {
    INCOME, EXPENSE
}

public class Transaction {
    private double amount;
    private TransactionType type;
    private String description;
    private Date date;
    
    public Transaction(TransactionType type, double amount, String description, Date date) {
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.date = date;        
    }
    
    public TransactionType getType() {
        return this.type;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    @Override
    public String toString() {
        return this.type + ", " + this.amount + ", " + this.description + ", " + this.date;
    }
    
}
