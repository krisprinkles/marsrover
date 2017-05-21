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

    // Orientations is a circular array, traverse it clockwise using mod 4 (set contains 4 element)
    // The array index starts at 0, therefore adjust orientationIndex with 1.
    public void turnRight()
    {
        orientationIndex = (orientationIndex + 1) % 4;
    }


    public void turnLeft()
    {
        if (orientationIndex == 0)
        {
            orientationIndex = 3;
        } else if(orientationIndex == 3) {
            orientationIndex = 2;
        } else if (orientationIndex == 2)
        {
            orientationIndex = 1;
        }
    }
}
