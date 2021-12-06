package services;

import java.util.ArrayList;

public class Credit {
    private int ID = 0;
    private double interestRate;
    private int maximalTerm;//in monthes
    private int creditAmount;
    private long clientId;

    private static ArrayList<Credit> availableCredits = new ArrayList<Credit>();

    public Credit() {
    }

    public Credit(double interestRate, int maximalTerm, int maxCreditAmount) {
        this.interestRate = interestRate;
        this.maximalTerm = maximalTerm;
        this.creditAmount = maxCreditAmount;
    }

    public Credit(double interestRate, int maximalTerm, int creditAmount, long clientId) {
        this.ID = ID++;
        this.interestRate = interestRate;
        this.maximalTerm = maximalTerm;
        this.creditAmount = creditAmount;
        this.clientId = clientId;
    }

    public ArrayList<Credit> getAvailableCredits() {
        availableCredits.add(new Credit(6.8, 5, 10000));
        availableCredits.add(new Credit(3.2, 12, 100000));
        availableCredits.add(new Credit(1.4, 24, 1000000));
        availableCredits.add(new Credit(0.5, 48, 10000000));
        return availableCredits;
    }

    public int getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(int creditAmount) {
        this.creditAmount = creditAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getMaximalTerm() {
        return maximalTerm;
    }

    public void setMaximalTerm(int maximalTerm) {
        this.maximalTerm = maximalTerm;
    }

    public int getID() {
        return ID;
    }
}
