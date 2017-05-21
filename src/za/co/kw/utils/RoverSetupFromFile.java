package za.co.kw.utils;

import za.co.kw.exception.StartingPositionException;
import za.co.kw.exception.TerritoryBoundaryException;

/**
 * Created by kristien on 2017/05/21.
 */
public class RoverSetupFromFile
{

    public static String[] readBoundaryCoords(String line) throws TerritoryBoundaryException
    {
        if (!line.matches("^\\d+\\s\\d+$"))
        {
            throw new TerritoryBoundaryException(String.format("The starting boundaries (%s) must be integers", line));
        }

        return line.split(" ");
    }

    public static String[] readStartingPosition(String line) throws StartingPositionException
    {
        if (!line.matches("^\\d+\\s\\d+\\s[NESW]$"))
        {
            throw new StartingPositionException(String.format("The starting position is invalid: %s ", line));
        }
        return line.split(" ");
    }
}
