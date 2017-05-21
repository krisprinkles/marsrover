package za.co.kw;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestCommandInterpreter
{
    @Test
    public void testFailForEmptyCommandList() throws Exception {
        String commandList = "";
        CommandInterpreter cp = new CommandInterpreter(commandList);
        assertFalse(cp.isValidCommand());
    }
}