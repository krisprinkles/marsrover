package za.co.kw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import za.co.kw.exception.TerritoryBoundaryException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestMovement
{
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void testItStartsAtZero() throws Exception {
        Rover r = new Rover(5,5);
        assertArrayEquals(r.getPosition(), new int[]{0, 0});
    }

    @Test
    public void testItMovesNorth() throws Exception {
        Rover r = new Rover(6,6);
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{0, 1});
    }

    @Test
    public void testItMovesEast() throws Exception {
        Rover r = new Rover(3,3);
        r.turnRight();
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{1, 0});
    }

    @Test
    public void testItMovesSouth() throws Exception {
        Rover r = new Rover(6,6);
        r.move();
        r.move();
        r.turnRight();
        r.turnRight();
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{0,1});
    }

    @Test
    public void testItMovesWest() throws Exception {
        Rover r = new Rover(4,4);
        r.turnRight();
        r.move();
        r.move();
        r.turnLeft();
        r.turnLeft();
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{1,0});
    }

    @Test
    public void testItStopsAtSouthernBoundary() throws Exception {
        int horizontalBoundary = 5;
        int verticalBoundary = 5;
        Rover r = new Rover(horizontalBoundary, verticalBoundary);
        r.turnRight();
        r.turnRight();
        exception.expect(TerritoryBoundaryException.class);
        r.move();
    }

    @Test
    public void testItStopsAtWesternBoundary() throws Exception {
        Rover r = new Rover(6,6);
        r.turnLeft();
        exception.expect(TerritoryBoundaryException.class);
        r.move();
    }

    @Test
    public void testItStopsAtNorthernBoundary() throws Exception {
        Rover r = new Rover(3,3);
        r.move();
        r.move();
        exception.expect(TerritoryBoundaryException.class);
        r.move();
    }

    @Test
    public void testItStopsAtEasternBoundary() throws Exception {
        Rover r = new Rover(3,3);
        r.turnRight();
        r.move();
        r.move();
        exception.expect(TerritoryBoundaryException.class);
        r.move();
    }

    @Test
    public void testItReportsDefaultStartingPositionCorrectly() throws Exception {
        Rover r = new Rover(5,5);
        assertEquals(r.reportPosition(), "0 0 N");
    }

    @Test
    public void testItMovesOnMCommand() throws Exception {
        char command = 'M';
        Rover r = new Rover(8,8);
        r.executeSingleCommand(command);
        assertEquals(r.reportPosition(), "0 1 N");
    }

    @Test
    public void testItTurnsRightOnRCommand() throws Exception {
        char command = 'R';
        Rover r = new Rover(8,8);
        r.executeSingleCommand(command);
        assertEquals(r.reportPosition(), "0 0 E");
    }

    @Test
    public void testItTurnsLeftOnLCommand() throws Exception {
        char command = 'L';
        Rover r = new Rover(8,8);
        r.executeSingleCommand(command);
        assertEquals(r.reportPosition(), "0 0 W");
    }

    @Test
    public void testItCompletesCommandListSuccessfully() throws Exception
    {
        String commandList = "MMRMRMML";
        Rover r = new Rover(5,5); // constructor assumes starting position 0 0 N
        r.setCommandList(commandList);
        r.executeCommandList();
        assertEquals(r.reportPosition(), "1 0 E");
    }
}