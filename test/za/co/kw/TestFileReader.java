package za.co.kw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import za.co.kw.exception.TerritoryBoundaryException;
import za.co.kw.utils.RoverSetupFromFile;

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


}