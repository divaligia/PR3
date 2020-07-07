package fileIO.binaryinput;

import java.io.*;

public class ReadBinaryData {

    public static void main(String[] args) throws IOException {
        // Datei muss bereits existieren!!
        File f = new File("binaryOutput.txt");

        // FileInputStream stellt Verbindung zur Datei her, Datei wird geöffnet:
        FileInputStream fis = new FileInputStream(f);

        // Für Optimierung der Performance:
        BufferedInputStream bis = new BufferedInputStream(fis);

        // read() liefert Byte für Byte aus der Datei. Wenn das Ende erreicht ist
        // dann liefert die Methode -1 als Ergebnis.
        // while Schleife liest somit Zeichen für Zeichen aus.

        int byteRead;
        while((byteRead = bis.read()) != -1){
            // BufferedInputStream
            // System.out.println((char)byteRead);
            // Byte wird in char umgewandelt
//            char[] ch = Character.toChars(byteRead);
//            System.out.println(ch);
            System.out.println((char) byteRead);
        }

        // close() gibt die Datei wieder frei.
        fis.close();
    }
}
