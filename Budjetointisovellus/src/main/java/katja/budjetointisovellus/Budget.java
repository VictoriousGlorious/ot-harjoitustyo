
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
        this.saved = 0;
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
        return this.name + ", tavoite: " + this.goal + ", säästöaika: " + this.start + "-" + this.end + ", säästetty: " + this.saved;
    }
    
}
