package fileIO.b_input_output;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Programm welches eine Textdatei mittels Filewriter und Printwriter erstellt
public class PrintWriterExample {
       public static void main(String[] args) throws IOException {
           FileWriter fw = new FileWriter("test.txt");
           PrintWriter pw = new PrintWriter(fw);

           pw.println("FirstLn");
           pw.println("SecondLn");
        // flush löst schreiben aus
           pw.flush();
        // close gibt datei frei
           pw.close();
       }
}
