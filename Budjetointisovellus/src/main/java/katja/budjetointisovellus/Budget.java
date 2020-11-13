
package katja.budjetointisovellus;

import java.util.Date;


public class Budget {
    
    private String name;
    private double goal;
    private double saved;
    private Date start;
    private Date end;
    
    public Budget(String name, double goal, Date start, Date end) {
        this.name = name;
        this.goal = goal;
        this.start = start;
        this.end = end;
    }
    
    public void save(double amount) {
        if (amount < 0) {
            this.saved += amount;
        }
    }
    
    public double getSaved() {
        return this.saved;
    }
    
    public double getGoal() {
        return this.goal;
    }
    
    @Override
    public String toString() {
        return this.name + ":\n goal: " + this.goal + "\n saved: " + this.saved;
    }
    
}
