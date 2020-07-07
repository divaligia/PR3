package fileIO.b_input_output;
   // Schreiben Sie ein Programm, das Ihre Noten aus allen Fächern
   // im ersten Semester von der Konsole einliest und anschließend
   // als „.txt“ Datei speichert. Beispiel: ▪ PR1: 1 ▪ Englisch: 1
   // Die Eingabe endet, wenn das Wort „STOP“ eingegeben wird.
   // Verwenden Sie die Klassen BufferedReader, InputStreamReader und FileWriter

import java.io.*;

public class WriteFileFromUserInput {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("noten.txt");
        PrintWriter pw = new PrintWriter(fw);

        System.out.println("Bitte geben Sie ein Fach und die dazugehörige Note ein:");
        // Input empfangen:
        InputStreamReader isp = new InputStreamReader(System.in);
        // legt eine BufferedReader über den InputStreamReader
        BufferedReader bf = new BufferedReader(isp);

        // Zeile für zeile wird eingelesen
        String line;
        while(!(line = bf.readLine()).equals("stop")){
            // solange die ausgelesene Zeile kein stop enthält:
            pw.println(line);
            System.out.println(line);
        }
        // bufferedReader schließen
        bf.close();
        // flushen zum Schreiben
        pw.flush();
        pw.close();
    }
}
