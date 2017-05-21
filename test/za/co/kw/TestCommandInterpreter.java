package za.co.kw;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testPassForValidCommandList() throws Exception {
        String commandList = "MMLMRMMRRMML";
        CommandInterpreter ci = new CommandInterpreter(commandList);
        assertTrue(ci.isValidCommand());
    }
}