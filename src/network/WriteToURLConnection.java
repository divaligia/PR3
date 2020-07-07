package network;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
// URLConnection kann über die gegebene URL eine Verbindung zum Server aufbauen.
// Die Klasse ist abstrakt, und die Unterklassen implementieren konkrete
// Protokolle (wie HTTP), mit denen die Verbindung zum Inhalt aufgebaut wird.
// mit URL Connection kann ich GET/POST/PUT requests senden - interagieren
// durch connection erhalte ich auch etwas zurück
// mit der URL alleine lässt sich nur auslesen, url ist sehr kurzlebig, was auch immer das heißt

public class WriteToURLConnection {
    public static void main(String[] args)
    {
        URL url;
        try
        {
            // Man baut eine Connection zu wetter.at auf, stellt mit dem String beginnend mit GET in bw.write
            // eine Verbindung zu einer Subseite her, die man dann ausliest

            // wie file path --> conn.setDoOutput muss true sein, dann bekommt man keine Exception
            url = new URL("https://www.wetter.at");
            // openConnection öffnet/aktiviert eine Connection
            URLConnection conn = url.openConnection();
            // setDoOutput muss als true dekklariert werden, wenn man eine URL connection als Output schreiben möchte
            // default ist setOutput immer false - todo hä?
            conn.setDoOutput(true);
            // Mittels conn.getOutputStream werden (die dateien in) zeile 28-33 an die URL angefragt
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));

            // GET methode wird mittels bw.write aufgerufen
            bw.write("GET /wetter/oesterreich/steiermark/graz/index.html HTTP/1.1");
            bw.newLine();
            bw.write("Host: www.wetter.at");
            bw.newLine();
            bw.newLine();
            bw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // Wenn man die aufgerufene Seite nicht in der Console ausgelesen haben möchte, erstellt man
            // mit dem Printwriter ein neues File und übergibt dem den Inhalt
            PrintWriter pw = new PrintWriter("wettercontent.html");

            String line;
            while ((line = br.readLine()) != null)
            {
                pw.println(line);
                System.out.println(line);
            }
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
