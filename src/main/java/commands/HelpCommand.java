package commands;

import java.util.Map;

public class HelpCommand implements Command{
    @Override
    public void execute(){
        Map<Integer, Command> commands = Menu.getCommands();
        for (Integer key: Menu.getCommands().keySet()) {
            System.out.println(key + " " + commands.get(key).getName());
        }
    }
    @Override
    public Integer getKey(){
        return 6;
    }
    @Override
    public String getName(){
        return "Help";
    }
}
