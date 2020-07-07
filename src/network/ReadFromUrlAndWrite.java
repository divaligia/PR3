package network;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromUrlAndWrite {
    public static void main(String[] args) {
        try{
            File f = new File("url_auslesen.txt");
            BufferedReader fileContent = new BufferedReader(new FileReader(f));
            // URL Objekt erzeugen
            URL url = new URL((fileContent.readLine()));
            // BufferedReader zum auslesen vom Inhalt der URL
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            // So wird die html in einer Zeile ausgegeben, bf hat nur eine write methode
            BufferedWriter bf = new BufferedWriter(new FileWriter("content.html"));

            // Besser PW verwenden um das Dokument mehrzeilig und mit sinnvollen abständen auszugeben
            PrintWriter pw = new PrintWriter(new FileWriter("content.html"));

            String input;
            while ((input = bufferedReader.readLine()) != null) {
//                bf.write(input);
                pw.println(input);

            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
