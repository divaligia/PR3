package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class ReadFromUrl {
    public static void main(String[] args) {
        try{
            System.out.println("Bitte URL angeben: ");
            // Erster BufferedReader ist fuer das Lesen des Inputs
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            // URL Objekt erzeugen
            URL url = new URL((userInput.readLine()));
            // BufferedReader zum auslesen vom Inhalt der URL
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(url.openStream()));

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }
            bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
