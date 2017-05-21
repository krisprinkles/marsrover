package za.co.kw;

import za.co.kw.exception.CardinalPointException;
import za.co.kw.exception.TerritoryBoundaryException;

import java.util.Arrays;

/**
 * Created by kristien on 2017/05/21.
 */
public class Rover
{
    int orientationIndex = 0;
    CardinalPoint[] orientations = {CardinalPoint.NORTH, CardinalPoint.EAST, CardinalPoint.SOUTH, CardinalPoint.WEST};
    int horizontalPosition = 0;
    int verticalPosition = 0;
    int horizontalBoundary = 0;
    int verticalBoundary = 0;

    public Rover(int horizontalBoundary, int verticalBoundary)
    {
        this.horizontalBoundary = horizontalBoundary;
        this.verticalBoundary = verticalBoundary;
    }

    public Rover(int horizontalBoundary, int verticalBoundary, int verticalStartPosition, int horizontalStartPosition, char orientation) throws CardinalPointException
    {
        this.horizontalBoundary = horizontalBoundary;
        this.verticalBoundary = verticalBoundary;

        this.horizontalPosition = horizontalStartPosition;
        this.verticalPosition = verticalStartPosition;

        CardinalPoint orientationLookup = CardinalPoint.lookupByOrientation(orientation);
        orientationIndex = Arrays.asList(orientations).indexOf(orientationLookup);
    }


    public char getDirection()
    {
        return orientations[orientationIndex].getOrientation();
    }

    // Orientations is a circular array, traverse it clockwise using mod 4 (set contains 4 element)
    // The array index starts at 0, therefore adjust orientationIndex with 1.
    public void turnRight()
    {
        orientationIndex = (orientationIndex + 1) % 4;
    }


    // Traversing orientations anti-clockwise
    public void turnLeft()
    {
        orientationIndex = (orientationIndex + 3) % 4;
    }

    public int[] getPosition()
    {
        return new int[]{horizontalPosition, verticalPosition};
    }

    public void move() throws TerritoryBoundaryException
    {
        int newVerticalPosition = verticalPosition + orientations[orientationIndex].getVerticalMoveAmount();
        int newHorizontalPosition = horizontalPosition = horizontalPosition + orientations[orientationIndex].getHorizontalMoveAmount();

        if (newVerticalPosition < 0)
        {
            throw new TerritoryBoundaryException("Reached the Southern Boundary");
        }

        if (newVerticalPosition >= verticalBoundary)
        {
            throw new TerritoryBoundaryException("Reached the Northern Boundary");
        }

        if (newHorizontalPosition < 0)
        {
            throw new TerritoryBoundaryException("Reached the Western Boundary");
        }

        if (newHorizontalPosition >= horizontalBoundary)
        {
            throw new TerritoryBoundaryException("Reached the Western Boundary");
        }

        horizontalPosition = newHorizontalPosition;
        verticalPosition = newVerticalPosition;
    }

    public String reportPosition()
    {
        return new String(horizontalPosition + " " + verticalPosition + " " + orientations[orientationIndex].getOrientation());
    }


}
