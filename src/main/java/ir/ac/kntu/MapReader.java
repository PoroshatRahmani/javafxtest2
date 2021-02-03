package ir.ac.kntu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {

    public static String readFile(String filename) {

        String line = null;
        String str = "";

        try {
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            while((line = bufferedReader.readLine()) != null) {
                str += line;
                str += "\n";
            }
            str = MapConvertor.chomp(str);
        }catch(FileNotFoundException ex) {
            System.out.println("Unable to open file : ");
            System.err.println(filename);
            System.out.println("--");
            ex.printStackTrace();
        }catch(IOException ex) {
            System.out.println("Error with reading file : ");
            System.err.println(filename);
            System.out.println("--");
            ex.printStackTrace();
        }
        return str;
    }
}
