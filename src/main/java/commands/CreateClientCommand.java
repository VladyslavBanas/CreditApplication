package commands;

import data.Client;
import users.BankEmployee;

import java.util.Scanner;

public class CreateClientCommand implements Command {
    private Scanner console = new Scanner(System.in);
    @Override
    public void execute(){
        System.out.println("Enter information about client (name, surname, salary):");
        String name = console.nextLine();
        String surname = console.nextLine();
        int salary=console.nextInt();

        BankEmployee.addClient(new Client(name,surname,salary));
        System.out.println("Client "+name + " "+surname + " is added");
    }
    @Override
    public Integer getKey(){
        return 1;
    }
    @Override
    public String getName(){
        return "Create a client";
    }
}
