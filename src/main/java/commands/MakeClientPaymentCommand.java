package commands;

import data.Client;
import services.Credit;
import users.BankEmployee;

import java.util.Scanner;

public class MakeClientPaymentCommand implements Command {
    private Scanner console = new Scanner(System.in);
    @Override
    public void execute(){
        System.out.println("Enter client id:");
        Client client= BankEmployee.findClient(console.nextInt());
        if(client==null){
            System.out.println("Client with this id doesn't exist");
            return;
        }
        System.out.println("Enter credit id");
        Credit credit = BankEmployee.findCredit(console.nextInt(), client);
        if(credit==null){
            System.out.println("Your client doesn't have credit with such id.");
            return;
        }
        System.out.println("Enter amount of money:");
        int money = console.nextInt();
        if(money> credit.getCreditAmount()){
            System.out.println("Client need to pay only "+credit.getCreditAmount());
            return;
        }
        credit.setCreditAmount(credit.getCreditAmount()-money);
        System.out.println("Clients payment is accepted. Now their credit amount is "+credit.getCreditAmount());
    }
    @Override
    public Integer getKey(){
        return 3;
    }
    @Override
    public String getName(){
        return "Make client payment";
    }
}
