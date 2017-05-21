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
    CommandInterpreter commandInterpreter = null;

    public Rover(int horizontalBoundary, int verticalBoundary) throws TerritoryBoundaryException, CardinalPointException
    {
        this(horizontalBoundary, verticalBoundary, 0, 0, 'N');
    }

    // The following exceptions will be thrown when invalid setup information is passed in:
    // 1. CardinalPointException:       The cardinal point provided is not in (N, E, S, E)
    // 2. TerritoryBoundaryException:   The starting position provided is outside the specified territory boundary.
    //                                  Also, when territory boundary co-ordinates are negative.
    public Rover(int horizontalBoundary, int verticalBoundary, int verticalStartPosition, int horizontalStartPosition, char orientation) throws CardinalPointException, TerritoryBoundaryException
    {
        if (horizontalBoundary < 0 || verticalBoundary < 0)
        {
            throw new TerritoryBoundaryException("Territory Boundary co-ordinates cannot be negative values");
        }
        this.horizontalBoundary = horizontalBoundary;
        this.verticalBoundary = verticalBoundary;

        if (horizontalStartPosition >= horizontalBoundary || horizontalStartPosition < 0 || verticalStartPosition >= verticalBoundary || verticalStartPosition < 0)
        {
            throw new TerritoryBoundaryException(String.format("The starting position specified (%d, %d) is outside the territory boundary (%d, %d)"
                    , horizontalStartPosition, verticalStartPosition, horizontalBoundary, verticalBoundary));
        }
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

        // Specific check for each boundary was added in order to provide detailed feedback messages.
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

    public void executeSingleCommand(String command) throws TerritoryBoundaryException
    {
        if (command == "M")
        {
            move();
        } else if (command == "R")
        {
            turnRight();
        } else if (command == "L")
        {
            turnLeft();
        }
    }


}
