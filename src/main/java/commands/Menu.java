package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private static Map<Integer, Command> commands;
    private Scanner console = new Scanner(System.in);

    public Menu() {
        commands = new HashMap<>();
        CreateClientCommand createClientCommand = new CreateClientCommand();
        FindSuitableCreditCommand findSuitableCreditCommand = new FindSuitableCreditCommand();
        MakeClientPaymentCommand makeClientPaymentCommand = new MakeClientPaymentCommand();
        ChangeCreditTermsCommand changeCreditTermsCommand = new ChangeCreditTermsCommand();
        HelpCommand helpCommand = new HelpCommand();
        ExitCommand exitCommand = new ExitCommand();

        commands.put(createClientCommand.getKey(), createClientCommand);
        commands.put(findSuitableCreditCommand.getKey(), findSuitableCreditCommand);
        commands.put(makeClientPaymentCommand.getKey(), makeClientPaymentCommand);
        commands.put(changeCreditTermsCommand.getKey(), changeCreditTermsCommand);
        commands.put(helpCommand.getKey(), helpCommand);
        commands.put(exitCommand.getKey(),exitCommand);
    }

    public void execute() {
        while (true) {
            System.out.println("Enter command key:");
            int command = console.nextInt();
            if (commands.get(command)==null) {
                System.out.println("Wrong command");
                continue;
            } else commands.get(command).execute();
        }
    }

    public static Map<Integer, Command> getCommands() {
        return commands;
    }

    public void setCommands(Map<Integer, Command> commands) {
        this.commands = commands;
    }
}
