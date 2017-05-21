import za.co.kw.Rover;
import za.co.kw.exception.CardinalPointException;
import za.co.kw.exception.CommandLineException;
import za.co.kw.exception.StartingPositionException;
import za.co.kw.exception.TerritoryBoundaryException;
import za.co.kw.utils.RoverSetupFromFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by kristien on 2017/05/21.
 */
public class Main
{
    public static void main(String[] args)
    {
        // Use relative path to test with
        String fileName = "./test/testfiles/basic_test";
//        String fileName = "./test/testfiles/incorrect_starting_coords";
//        String fileName = "./test/testfiles/incorrect_boundary_coords";


        String[] boundaryArray = new String[2];
        String[] startingPosArray = new String[3];
        String commandList = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName)))
        {
            String line;

            // Read the first line
            if ((line = br.readLine()) != null)
            {
                try
                {
                    boundaryArray = RoverSetupFromFile.readBoundaryCoords(line);
                } catch (TerritoryBoundaryException e)
                {
                    System.out.println(e);
                }
            } else
            {
                System.out.println("Invalid file format: could not read the territory boundary co-ordinates on the first line");
            }

            // Read the second line
            if ((line = br.readLine()) != null)
            {
                try
                {
                    startingPosArray = RoverSetupFromFile.readStartingPosition(line);
                } catch (StartingPositionException e)
                {
                    System.out.println(e);
                }
            } else
            {
                System.out.println("Invalid file format: could not read the starting position on the second line.");
                return;
            }

            // Read the third line
            if ((line = br.readLine()) != null)
            {
                try
                {
                    commandList = RoverSetupFromFile.readCommandLine(line);
                } catch (CommandLineException e)
                {
                    System.out.println(e);
                }
            } else
            {
                System.out.println("Invalid file format: could not read the movement commands on the third line.");
                return;
            }

            // ignoring the rest of the file
            if (br.readLine() != null)
            {
                System.out.println("Ignoring the rest of the file");
            }

            // Construct Rover and issue instructions
            Rover r = new Rover(Integer.parseInt(boundaryArray[0])
                    , Integer.parseInt(boundaryArray[1])
                    , Integer.parseInt(startingPosArray[0])
                    , Integer.parseInt(startingPosArray[1])
                    , startingPosArray[2].charAt(0));

            System.out.format("Rover has been initialised for the specified territory (boundary: %s) and has moved to starting position: %s\n", r.reportTerritoryBoundary(), r.reportPosition());
            r.setCommandList(commandList);
            System.out.format("Rover has accepted the command(%s) and is ready to start moving\n", commandList);
            r.executeCommandList();
            System.out.format("Rover has moved and is now standing at position: %s\n", r.reportPosition() );
            System.out.println("Rover is standing by on minimal power");
            System.out.println("Rover is waiting for Mark Watney");

        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (CardinalPointException e)
        {
            System.out.println(e);
        } catch (TerritoryBoundaryException e)
        {
            System.out.println(e);
        }
    }

}
