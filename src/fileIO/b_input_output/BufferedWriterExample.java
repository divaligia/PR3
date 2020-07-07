package fileIO.b_input_output;
   // Der BufferedWriter stellt Implementierungen verschiedenster Methoden des Writers
   // write() Methode - schreibt einzelne character in den internen puffer des writers
   // write(char[] array) - schreibt characters vom array in den writer
   // write(String data) - schreibt den String in den writer

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main (String[] args) throws IOException {
        // fw erstellt eine neue Datei, mit dieser als parameter übergeben, fm wird dem bf übergeben
        FileWriter fw = new FileWriter("bufferedWriter.txt");
        BufferedWriter bf = new BufferedWriter(fw);

        String data = "das ist ein test";
        bf.write(data);
        bf.newLine();
        bf.write(data);
        bf.newLine();
      // Test ob FileWriter dateien erstellen und überschreiben kann
      // bf.write("wird auch überschrieben");
        bf.flush();
        bf.close();
        System.out.println("Fertig");
    }
}
