package za.co.kw.utils;

import za.co.kw.exception.TerritoryBoundaryException;

/**
 * Created by kristien on 2017/05/21.
 */
public class RoverSetupFromFile
{

    public static String readBoundaryCoords(String line) throws TerritoryBoundaryException
    {
        String[] territoryBoundaryCoords = line.split(" ");
        if (territoryBoundaryCoords.length == 2)
        {
            for (String tbc : territoryBoundaryCoords)
            {
                if (!tbc.matches("\\d+"))
                {
                    throw new TerritoryBoundaryException(String.format("The starting boundaries (%s) must be integers", line));
                }
            }
        } else
        {
            throw new TerritoryBoundaryException(String.format("Invalid starting boundaries provided in first line of file: %s", line));
        }

        // Continue if no errors were identified
        return line;
    }
}
