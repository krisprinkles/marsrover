package za.co.kw;

/**
 * Created by kristien on 2017/05/21.
 */
public class Rover
{
    char direction = 'N';

    public char getDirection()
    {
        return direction;
    }

    public void turnRight()
    {
        if (direction == 'N')
        {
            direction = 'E';
        } else if(direction == 'E') {
            direction = 'S';
        } else if (direction == 'S') {
            direction = 'W';
        }
    }
}
