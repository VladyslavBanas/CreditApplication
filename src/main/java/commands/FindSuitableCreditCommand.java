package commands;

import data.Client;
import services.Credit;
import users.BankEmployee;

import java.util.Scanner;

public class FindSuitableCreditCommand implements Command {
    private Scanner console = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Enter client ID:");
        int clientID = console.nextInt();
        Client client = BankEmployee.findClient(clientID);
        if (client == null) {
            System.out.println("Client with such id doesn't exist");
            return;
        }
        System.out.println("Enter sum of credit, your client wants");
        int sumOfCredit = console.nextInt();
        Credit credit = findSuitableCredit(client, sumOfCredit);
        if (credit == null) {
            System.out.println("Sorry, there isn't any suitable credit.");
            return;
        }
        client.addCredit(new Credit(credit.getInterestRate(), credit.getMaximalTerm(), credit.getCreditAmount(), clientID));
        System.out.println(client.getName() + " gets credit on the sum " + credit.getCreditAmount()
                + " with interest rate - " + credit.getInterestRate() + "%"
                + " for " + credit.getMaximalTerm() + " monthes!!!");
    }

    private Credit findSuitableCredit(Client client, int sumOfCredit) {
        Credit credit = new Credit();
        for (Credit tempCredit : credit.getAvailableCredits()) {
            if (tempCredit.getCreditAmount() >= sumOfCredit && sumOfCredit / tempCredit.getMaximalTerm() > client.getSalary() / 3) {
                credit = tempCredit;
                credit.setCreditAmount(sumOfCredit);
                return credit;
            }
        }
        return null;
    }

    @Override
    public Integer getKey() {
        return 2;
    }

    @Override
    public String getName() {
        return "Look for suitable credit terms";
    }
}
