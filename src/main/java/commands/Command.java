package commands;

public interface Command {
    void execute();
    Integer getKey();
    String getName();
}
