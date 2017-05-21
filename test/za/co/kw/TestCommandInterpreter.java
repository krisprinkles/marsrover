package za.co.kw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestCommandInterpreter
{
    @Test
    public void testFailForEmptyCommandList() throws Exception
    {
        String             commandList = "";
        CommandInterpreter cp          = new CommandInterpreter(commandList);
        assertFalse(cp.isValidCommand());
    }


    @Test
    public void testPassForValidCommandList() throws Exception
    {
        String             commandList = "MMLMRMMRRMML";
        CommandInterpreter ci          = new CommandInterpreter(commandList);
        assertTrue(ci.isValidCommand());
    }


    @Test
    public void testFailForInvalidCommandList() throws Exception
    {
        String             commandList = "MRLJMMMRRPLJ";
        CommandInterpreter cp          = new CommandInterpreter(commandList);
        assertFalse(cp.isValidCommand());
    }


    @Test
    public void testFailForSpecialCharactersInCommandList() throws Exception
    {
        String             commandList = "asf*&//<!KLRM";
        CommandInterpreter ci          = new CommandInterpreter(commandList);
        assertFalse(ci.isValidCommand());
    }


    @Test
    public void testScrubbedCommandListContainsNoWhiteSpace() throws Exception
    {
        String             commandList = "MJKURRR GHIS SFD ";
        CommandInterpreter ci          = new CommandInterpreter(commandList);
        assertEquals(ci.commandList.indexOf(" "), -1);
    }


    @Test
    public void testFailWhenCommandIsNull() throws Exception
    {
        CommandInterpreter ci = new CommandInterpreter(null);
        assertFalse(ci.isValidCommand());
    }
}