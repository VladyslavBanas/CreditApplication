package commands;

import data.Client;
import services.Credit;
import users.BankEmployee;

import java.util.Scanner;

public class ChangeInterestRateCommand implements Command{
    private Scanner console = new Scanner(System.in);
    @Override
    public void execute(){
        System.out.println("Enter client ID:");
        int clientID = console.nextInt();
        Client client = BankEmployee.findClient(clientID);
        if (client == null) {
            System.out.println("Client with such id doesn't exist");
            return;
        }

        System.out.println("Enter credit id");
        Credit credit = BankEmployee.findCredit(console.nextInt(), client);
        if(credit==null){
            System.out.println("Your client doesn't have credit with such id.");
            return;
        }

        System.out.println("Enter new interest rate");
        double interRate = console.nextDouble();
        credit.setInterestRate(interRate);
        System.out.println("Interest rate was succesfully changed!");
    }
    @Override
    public Integer getKey(){
        return 1;
    }
    @Override
    public String getName(){
        return null;
    }
}
