package za.co.kw;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by kristien on 2017/05/21.
 */
public class TestMovement
{
    @Test
    public void testItStartsAtZero() throws Exception {
        Rover r = new Rover();
        assertArrayEquals(r.getPosition(), new int[]{0, 0});
    }

    @Test
    public void testItMovesNorth() throws Exception {
        Rover r = new Rover();
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{0, 1});
    }

    @Test
    public void testItMovesEast() throws Exception {
        Rover r = new Rover();
        r.turnRight();
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{1, 0});
    }

    @Test
    public void testItMovesSouth() throws Exception {
        Rover r = new Rover();
        r.move();
        r.move();
        r.turnRight();
        r.turnRight();
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{0,1});
    }

    @Test
    public void testItMovesWest() throws Exception {
        Rover r = new Rover();
        r.turnRight();
        r.move();
        r.move();
        r.turnLeft();
        r.turnLeft();
        r.move();
        assertArrayEquals(r.getPosition(), new int[]{1,0});
    }

}