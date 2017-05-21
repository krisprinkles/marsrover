package za.co.kw;

import org.junit.Test;
import za.co.kw.exception.TerritoryBoundaryException;

import static org.junit.Assert.assertTrue;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestTurning
{

    @Test
    public void testNewRoverFacesNorth() throws TerritoryBoundaryException
    {
        Rover r = new Rover(6,7);
        assertTrue(Character.toUpperCase(r.getDirection()) == 'N');
    }

    @Test
    public void testNewRoverFacesEastAfterSingleRightTurn() throws Exception
    {
        Rover r = new Rover(4,4);
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'E');
    }

    @Test
    public void testNewRoverFacesSouthAfterTwoRightTurn() throws Exception
    {
        Rover r = new Rover(3,5);
        r.turnRight();
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'S');
    }

    @Test
    public void testNewRoverFacesWestAfterThreeRightTurn() throws Exception
    {
        Rover r = new Rover(6,6);
        r.turnRight();
        r.turnRight();
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'W');
    }

    @Test
    public void testNewRoverFacesNorthAfterFourRightTurns() throws Exception {
        Rover r = new Rover(5,5);
        r.turnRight();
        r.turnRight();
        r.turnRight();
        r.turnRight();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'N');
    }

    @Test
    public void testNewRoverFacesWestAfterSingleLeftTurn() throws TerritoryBoundaryException
    {
        Rover r = new Rover(3,3);
        r.turnLeft();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'W');
    }

    @Test
    public void testNewRoverFacesSouthAfterTwoLeftTurns() throws TerritoryBoundaryException
    {
        Rover r = new Rover(2,2);
        r.turnLeft();
        r.turnLeft();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'S');
    }

    @Test
    public void testNewRoverFacesEastAfterThreeLeftTurns() throws TerritoryBoundaryException
    {
        Rover r = new Rover(4,4);
        r.turnLeft();
        r.turnLeft();
        r.turnLeft();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'E');
    }

    @Test
    public void testNewRoverFacesNorthAfterFourLeftTurns() throws TerritoryBoundaryException
    {
        Rover r = new Rover(6,6);
        r.turnLeft();
        r.turnLeft();
        r.turnLeft();
        r.turnLeft();
        assertTrue(Character.toUpperCase(r.getDirection()) == 'N');
    }

}