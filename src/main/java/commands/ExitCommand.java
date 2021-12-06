package commands;

public class ExitCommand implements Command{
    @Override
    public void execute(){
        System.exit(0);
    }
    @Override
    public Integer getKey(){
        return 7;
    }
    @Override
    public String getName(){
        return "Exit";
    }
}
