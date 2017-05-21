package za.co.kw.utils;

import za.co.kw.exception.StartingPositionException;
import za.co.kw.exception.TerritoryBoundaryException;

/**
 * Created by kristien on 2017/05/21.
 */
public class RoverSetupFromFile
{

    public static int[] readBoundaryCoords(String line) throws TerritoryBoundaryException
    {
        String[] territoryBoundaryCoords = line.split(" ");
        int[] territoryBoundary = {0,0};

        if (territoryBoundaryCoords.length == 2)
        {
            int counter=0;
            for (String tbc : territoryBoundaryCoords)
            {
                if (!tbc.matches("\\d+"))
                {
                    throw new TerritoryBoundaryException(String.format("The starting boundaries (%s) must be integers", line));
                }
                territoryBoundary[counter] = Integer.parseInt(tbc);
                counter++;
            }
        } else
        {
            throw new TerritoryBoundaryException(String.format("Invalid starting boundaries provided in first line of file: %s", line));
        }

        // Continue if no errors were identified
        return territoryBoundary;
    }

    public static String[] readStartingPosition(String line) throws StartingPositionException
    {
        String[] startingPositionList = line.split(" ");

        if (startingPositionList.length != 3)
        {
            throw new StartingPositionException(String.format("Invalid staring position provided in the second line of the file: %s", line));
        }
        return startingPositionList;
    }
}
