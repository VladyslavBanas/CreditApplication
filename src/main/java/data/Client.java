package data;

import services.Credit;

import java.util.ArrayList;

public class Client {
    private long id=0;
    private String name;
    private String surname;
    private int salary;
    private ArrayList<Credit>credits=new ArrayList<>();

    public Client(String name, String surname, int salary) {
        this.id ++;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public ArrayList<Credit> getCredits() {
        return credits;
    }

    public void removeCredit(Credit credit) {
        for (Credit temp :credits){
            if(temp.equals(credit)) {
                credits.remove(temp);
                return;
            }
        }
    }
    public void addCredit(Credit credit) {
        credits.add(credit);
    }
}
