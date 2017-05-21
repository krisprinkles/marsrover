import za.co.kw.Rover;
import za.co.kw.utils.RoverSetupFromFile;

/**
 * Created by kristien on 2017/05/21.
 */
public class Main
{


    public static void main(String[] args)
    {
        String   fileName         = "./test/testfiles/basic_test";

        try
        {
            Rover rover = RoverSetupFromFile.getRoverFromFile(fileName);

            System.out.format("Rover has been initialised for the specified territory (boundary: %s) and has moved to" +
                              " starting position: %s\n", rover.reportTerritoryBoundary(), rover.reportPosition());
            System.out.format("Rover has accepted the commands and is ready to start moving\n");
            rover.executeCommandList();
            System.out.format("Rover has moved and is now standing at position: %s\n", rover.reportPosition());
            System.out.println("Rover is standing by on minimal power");
            System.out.println("Rover is waiting for Mark Watney");

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }




}
