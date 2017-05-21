package za.co.kw.utils;

import za.co.kw.Rover;
import za.co.kw.exception.CardinalPointException;
import za.co.kw.exception.CommandLineException;
import za.co.kw.exception.StartingPositionException;
import za.co.kw.exception.TerritoryBoundaryException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kristien on 2017/05/21.
 */
public class RoverSetupFromFile
{


    private static final int HORIZONTAL_BOUNDARY       = 0;
    private static final int VERTICAL_BOUNDARY         = 1;
    private static final int HORIZONTAL_START_POSITION = 0;
    private static final int VERTICAL_START_POSITION   = 1;
    private static final int ORIENTATION               = 2;


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


    public static String readCommandLine(String line) throws CommandLineException
    {
        if (!line.matches("[LMR]+"))
        {
            throw new CommandLineException(String.format("Invalid Command Line provided: %s", line));
        }
        return line;
    }


    public static Rover getRoverFromFile(String filename)
            throws CardinalPointException, CommandLineException, IOException,
                   StartingPositionException, TerritoryBoundaryException
    {
        Rover          rover       = new Rover();
        BufferedReader fileBuffer  = new BufferedReader(new FileReader(filename));
        String         commandList = null;
        String[]       boundaryArray;
        String[]       startingPosArray;

        String line = "";
        if ((line = fileBuffer.readLine()) != null)
        {
            boundaryArray = readBoundaryCoords(line);
            rover.setHorizontalBoundary(Integer.parseInt(boundaryArray[HORIZONTAL_BOUNDARY]));
            rover.setVerticalBoundary(Integer.parseInt(boundaryArray[VERTICAL_BOUNDARY]));
        }

        if ((line = fileBuffer.readLine()) != null)
        {
            startingPosArray = readStartingPosition(line);
            rover.setHorizontalPosition(Integer.parseInt(startingPosArray[HORIZONTAL_START_POSITION]));
            rover.setVerticalPosition(Integer.parseInt(startingPosArray[VERTICAL_START_POSITION]));
            rover.setOrientation(startingPosArray[ORIENTATION].charAt(0));
        }

        if ((line = fileBuffer.readLine()) != null)
        {
            commandList = readCommandLine(line);
            rover.setCommandList(commandList);
        }

        return rover;
    }
}
