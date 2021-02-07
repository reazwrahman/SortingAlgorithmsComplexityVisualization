import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class FileReadWrite
{


    public boolean writer(String filename,String content)
    {
        boolean success=true;

        try
        {
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(content);
            myWriter.close();
        }
        catch (IOException e)
        {
            success=false;
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return success;

    }

    public boolean appender(String filename, String content)
    {
        boolean success=true;

        File file = new File(filename);
        FileWriter fr = null;
        BufferedWriter br = null;
        try
        {
            // to append to file, you need to initialize FileWriter using below constructor
            fr = new FileWriter(file, true);
            br = new BufferedWriter(fr);

            br.write(content);
        }

        catch (IOException e)
        {
            success=false;
            e.printStackTrace();
        }
        finally
        {
            try
            {
                br.close();
                fr.close();
            }
            catch (IOException e)
            {
                success=false;
                e.printStackTrace();
            }
        }
        return success;
    }


}
