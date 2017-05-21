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
//        String fileName = "./test/testfiles/incorrect_boundary_coords";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            String[] boundaryArray;
            String[] startingPosArray;

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

            }




//            if ((line = br.readLine()) != null)
//            {
//
//            }

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
