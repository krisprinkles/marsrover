package za.co.kw;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import za.co.kw.exception.TerritoryBoundaryException;

import static org.junit.Assert.assertArrayEquals;

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


}