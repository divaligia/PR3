package fileIO.b_input_output;

    // wenn viele Schreiboperationen gemacht werden, macht das Puffern die Dateioperationen
    // schneller, da so mehrere Schreiboperationen zu einer zusammengefasst werden

import java.io.*;

public class bufferedReaderExample {
    public static void main(String[] args) throws IOException {

        // Datei text.txt öffnen
        File file = new File("C:\\Users\\kursinstall\\Documents\\Pr3\\neu\\test.txt");

        // liefert einen textortiernten Stream der Datei zurück
        // liest Zeichen für Zeichen aus
        FileReader fileReader = new FileReader(file);

        // BufferedReader über FileReader legen, damit man auf die Datei kompfortabler zugreifen kann
        // Durch den BufferedReader wird die while-Schleife weniger oft aufgerufen werden, weil
        // eben Zeilen und nicht Zeichen ausgelesen werden müssen
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        // Zeile für Zeile wird eingelesen. Wenn das Dateiende erreicht ist, soll null zurückgeliefert werden
        String line;
        // solange eine weitere Zeile vorhanden ist, gib aus
        while ((line = bufferedReader.readLine()) != null){
            System.out.println("\t" + line);
            System.out.println("Neuer Satz");
        }

        // Datei schließen
        bufferedReader.close();

    }
}
