package za.co.kw;

/**
 * Created by kristien on 2017/05/21.
 */
public class Rover
{
    int orientationIndex = 0;
    char[] orientations = {'N', 'E', 'S', 'W'};

    public char getDirection()
    {
        return orientations[orientationIndex];
    }

    public void turnRight()
    {
        orientationIndex = (orientationIndex + 1) % 4;
    }
}
