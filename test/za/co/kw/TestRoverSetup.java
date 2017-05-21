package za.co.kw;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestRoverSetup
{

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

}