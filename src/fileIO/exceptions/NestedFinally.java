package fileIO.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NestedFinally {
    public static void main(String[] args) {
        nestedFinally("fileIO.umlaute.txt");

    }

    private static void nestedFinally(String fileName) {
        try {
            // If the constructor throws an exception, the finally block will NOT execute
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            try {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    // process the line...
                }
            } finally {
                // no need to check for null
                // any fileIO.exceptions thrown here will be caugth by the outer catch block
                reader.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(1);
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(2);
            ex.printStackTrace();
        }
    }
}
