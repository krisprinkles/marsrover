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

    @Test
    public void testNewRoverFacesEastAfterSingleRightTurn() throws Exception
    {
        Rover r = new Rover();
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'E');
    }

    @Test
    public void testNewRoverFacesSouthAfterTwoRightTurn() throws Exception
    {
        Rover r = new Rover();
        r.turnRight();
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'S');
    }

    @Test
    public void testNewRoverFacesWestAfterThreeRightTurn() throws Exception
    {
        Rover r = new Rover();
        r.turnRight();
        r.turnRight();
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'W');
    }

    @Test
    public void testNewRoverFacesNorthAfterFourRightTurns() throws Exception {
        Rover r = new Rover();
        r.turnRight();
        r.turnRight();
        r.turnRight();
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'N');
    }

    @Test
    public void testNewRoverFacesWestAfterSingleLeftTurn()
    {
        Rover r = new Rover();
        r.turnLeft();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'W');
    }

    @Test
    public void testNewRoverFacesSouthAfterTwoLeftTurns()
    {
        Rover r = new Rover();
        r.turnLeft();
        r.turnLeft();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'S');
    }

    @Test
    public void testNewRoverFacesEastAfterThreeLeftTurns()
    {
        Rover r = new Rover();
        r.turnLeft();
        r.turnLeft();
        r.turnLeft();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'E');
    }



}