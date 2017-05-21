package za.co.kw;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestTurning
{

    @Test
    public void testNewRoverFacesNorth()
    {
        Rover r = new Rover();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'N');
    }

}