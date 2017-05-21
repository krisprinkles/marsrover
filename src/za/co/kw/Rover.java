package za.co.kw;

/**
 * Created by kristien on 2017/05/21.
 */
public class Rover
{
    int orientationIndex = 0;

    CardinalPoint[] orientations = {CardinalPoint.NORTH, CardinalPoint.EAST, CardinalPoint.SOUTH, CardinalPoint.WEST};
    int horizontalPosition = 0;
    int verticalPosition = 0;

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

    public void move()
    {
        verticalPosition = verticalPosition + orientations[orientationIndex].getVerticalMoveAmount();
        horizontalPosition = horizontalPosition + orientations[orientationIndex].getHorizontalMoveAmount();
    }


}
