package za.co.kw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import za.co.kw.exception.CommandLineException;
import za.co.kw.exception.StartingPositionException;
import za.co.kw.exception.TerritoryBoundaryException;
import za.co.kw.utils.RoverSetupFromFile;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestFileReader
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();


    @Test
    public void testItFailsForTooManyTerritoryBoundaryCoords() throws Exception
    {
        String line = "5 4 6 7";
        exception.expect(TerritoryBoundaryException.class);
        RoverSetupFromFile.readBoundaryCoords(line);
    }


    @Test
    public void testItFailsForNonNumericTerritoryBoundaryCoords() throws Exception
    {
        String line = "5s E";
        exception.expect(TerritoryBoundaryException.class);
        RoverSetupFromFile.readBoundaryCoords(line);
    }


    @Test
    public void testItFailsForNonIntegerTerritoryBoundaryCoords() throws Exception
    {
        String line = "5.4 3.0";
        exception.expect(TerritoryBoundaryException.class);
        RoverSetupFromFile.readBoundaryCoords(line);
    }


    @Test
    public void testFailsForTooManyStartingPositionCoords() throws Exception
    {
        String line = "1 2 E R S 2";
        exception.expect(StartingPositionException.class);
        RoverSetupFromFile.readStartingPosition(line);
    }


    @Test
    public void testFailsForInvalidCharactersInStartingPosition() throws Exception
    {
        String line = "1 2 F";
        exception.expect(StartingPositionException.class);
        RoverSetupFromFile.readStartingPosition(line);
    }


    @Test
    public void testPassForValidStartingPosition() throws Exception
    {
        String   line       = "1 2 E";
        String[] resultLine = RoverSetupFromFile.readStartingPosition(line);
        assertArrayEquals(resultLine, new String[]{"1", "2", "E"});
    }


    @Test
    public void testFailForInvalidCharactersInCommandLine() throws Exception
    {
        String line = "HJMMRLNRMM 452 4 %#";
        exception.expect(CommandLineException.class);
        String resultLine = RoverSetupFromFile.readCommandLine(line);
    }


    @Test
    public void testLoadOfInstructions() throws Exception
    {
        String filename = "./test/testfiles/basic_test";
        Rover rover = RoverSetupFromFile.getRoverFromFile(filename);

        assertEquals(rover.getDirection(), 'E');
        assertEquals(rover.getPosition()[0], 1);
        assertEquals(rover.getPosition()[1], 2);
    }
}