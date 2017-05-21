package za.co.kw;

/**
 * Created by kristien on 2017/05/21.
 */
public class CommandInterpreter
{
    String commandList = "";

    public CommandInterpreter(String commandList)
    {
        this.commandList = scrubCommand(commandList);
    }

    public boolean isValidCommand()
    {
        if (this.commandList != null && this.commandList.matches("[LMR]+"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String scrubCommand(String command)
    {
        String scrubbed = command;
        if(command!=null){
            scrubbed = command.replace(" ","").toUpperCase();
        }
        return scrubbed;
    }

    public void setCommandList(String commandList)
    {
        this.commandList = commandList;
    }

    public String getCommand()
    {
        return commandList;
    }
}
