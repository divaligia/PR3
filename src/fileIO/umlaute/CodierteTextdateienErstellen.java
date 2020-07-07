package fileIO.umlaute;

import java.io.*;

import static java.nio.charset.StandardCharsets.ISO_8859_1;

public class CodierteTextdateienErstellen {
    public static void main(String[] args) {
        File file = new File("fileIO.umlaute.txt");

        try(
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            // Mit Umlaute: ä ö
            // OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, UTF_8);
            // Ohne Umlaute: ä ö
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, ISO_8859_1);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter)){
            printWriter.println("Köche machen Müsli mit Äpfeln");
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
