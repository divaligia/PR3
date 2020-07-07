package fileIO.b_input_output;
   // Schreiben Sie ein Programm, das zeilenweise Tastatureingaben auf die Konsole schreibt,
   // bis das Wort „STOP“ eingegeben wird. Verwenden Sie dazu den InputStream System.in
   // Verwenden Sie weiters die Klassen:
   // ▪ InputStreamReader und BufferedReader

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class read_system_input {
    public static void main(String[] args) throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);

        // BufferedReader über InputstreamReader legen
        BufferedReader bR = new BufferedReader(isr);

        // Zeilenweise einlesen:
        String line;
        while ((line = bR.readLine()) != null){
            System.out.println(line);
            // check of input stop ist:
            if(line.equals("stop")){
            // wenn ja, aus der whileSchleife raus
                break;
            }
        }
        // bufferedReader schließen
        bR.close();
        // Information, dass das Programm geschlossen ist
        System.out.println("Closed due to Input: stop");

    }
}
