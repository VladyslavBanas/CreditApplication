package commands;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChangeCreditTermsCommand implements Command{

    private Map<Integer, Command> commands=new HashMap<>();
    private Scanner console = new Scanner(System.in);

    @Override
    public void execute() {
        ChangeInterestRateCommand changeInterestRateCommand = new ChangeInterestRateCommand();
        ChangeCreditAmountCommand changeCreditAmountCommand = new ChangeCreditAmountCommand();
        ChangeCreditMaxTermCommand changeCreditMaxTermCommand = new ChangeCreditMaxTermCommand();
        ExitCommand exitCommand = new ExitCommand();

        commands.put(changeInterestRateCommand.getKey(), changeInterestRateCommand);
        commands.put(changeCreditAmountCommand.getKey(), changeCreditAmountCommand);
        commands.put(changeCreditMaxTermCommand.getKey(), changeCreditMaxTermCommand);
        commands.put(exitCommand.getKey(), exitCommand);

        while (true) {
            System.out.println("Enter command key (enter 0 to exit to main menu):");
            int command = console.nextInt();
            if(command==0)
                return;
            if (commands.get(command)==null) {
                System.out.println("Wrong command");
                continue;
            } else commands.get(command).execute();
        }
    }
    @Override
    public Integer getKey(){
        return 4;
    }
    @Override
    public String getName(){
        return "Change credit terms";
    }
}
