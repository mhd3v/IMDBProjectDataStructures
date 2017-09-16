package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class reading 
{

	public static void main(String[] args) 
	{

        String csvFile = "C:\\Users\\Maximus\\Downloads\\IMDB.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] abc = line.split(cvsSplitBy);

               for(int i=0;i<abc.length;i++)
               {
            	   System.out.print(abc[i]+"  ||   ");
               }
               System.out.println();

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
}
