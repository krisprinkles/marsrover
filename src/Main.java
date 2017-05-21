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
//        String fileName = "./test/testfiles/basic_test";
        String fileName = "./test/testfiles/incorrect_boundary_coords";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // READ the first line
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
