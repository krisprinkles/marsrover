package za.co.kw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import za.co.kw.exception.CardinalPointException;
import za.co.kw.exception.TerritoryBoundaryException;

import static org.junit.Assert.assertEquals;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestRoverSetup
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testItStartAtTheSpecifiedCoordinates() throws Exception
    {
        int horizontalBoundary = 5;
        int verticalBoundary = 5;
        int horizontalStart = 1;
        int verticalStart = 2;
        char startingOrientation = 'E';
        Rover r = new Rover(horizontalBoundary, verticalBoundary, horizontalStart, verticalStart, startingOrientation);
        assertEquals(r.reportPosition(), "2 1 E");
    }

    @Test
    public void testItFailsWhenGivenInvalidCardinalPoint() throws Exception
    {
        int horizontalBoundary = 5;
        int verticalBoundary = 5;
        int horizontalStart = 1;
        int verticalStart = 2;
        char startingOrientation = 'K';
        exception.expect(CardinalPointException.class);
        Rover r = new Rover(horizontalBoundary, verticalBoundary, horizontalStart, verticalStart, startingOrientation);
    }

    @Test
    public void testItFailsWhenGivenStartingCoordsOutsideTerritoryLimits() throws Exception
    {
        int horizontalBoundary = 5;
        int verticalBoundary = 5;
        int horizontalStart = 5;
        int verticalStart = 6;
        char startingOrientation = 'S';
        exception.expect(TerritoryBoundaryException.class);
        Rover r = new Rover(horizontalBoundary, verticalBoundary, horizontalStart, verticalStart, startingOrientation);
    }

    @Test
    public void testItFailsWhenNegativeBoundaryCoordsAreGiven() throws Exception
    {
        int horizontalBoundary = -1;
        int verticalBoundary = -3;
        int horizontalStart = -5;
        int verticalStart = -6;
        char startingOrientation = 'S';
        exception.expect(TerritoryBoundaryException.class);
        Rover r = new Rover(horizontalBoundary, verticalBoundary, horizontalStart, verticalStart, startingOrientation);
    }

    @Test
    public void testItFailsWhenOnlyNegativeBoundaryCoordsAreGiven() throws Exception
    {
        int horizontalBoundary = -1;
        int verticalBoundary = -3;
        exception.expect(TerritoryBoundaryException.class);
        Rover r = new Rover(horizontalBoundary, verticalBoundary);
    }
}