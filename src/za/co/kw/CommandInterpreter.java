package za.co.kw;

/**
 * Created by kristien on 2017/05/21.
 */
public class CommandInterpreter
{
    String commandList = "";

    public CommandInterpreter(String commandList)
    {
        this.commandList = commandList;
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
}
