import javax.swing.*;
import java.io.*;                   // for general file handling
public class FILEWRITECSV
{
    private FileWriter fWriter;     // an object to fetch data from fil

   
   public void writeCSVtable(String outBuffer) throws IOException
    {
        String csvFile;
        
        csvFile = "fridayOutput.csv";

        // open the file
        fWriter = new FileWriter(csvFile);    
        // write ALL the to the file in 1 burst
        fWriter.write(outBuffer); 
        // close the file
        fWriter.close();
    } 
}