package network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.util.Calendar;
import java.util.GregorianCalendar;

// Mit Socket erstellt man einen Server, ein Server verarbeitet - in unserem Fall
// liefert er die aktuelle Uhrzeit zurück

// start via CommandLine: telnet localhost 9090
public class ListenToClient {
    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        ServerSocket server = null;    // server - muss zuerst erstellt werden, weil dieser einen socket erstellt
        Socket connectionToClient = null;     // client - muss die verbindung zum socket akzeptieren

        try{
            System.out.println("Warte...");
            // Server erstellt socket in port nummer 9090 und wartet auf das akzeptieren des clients
            server = new ServerSocket(9090);
            // socket wird nur erstellt, wenn server.accept aufgerufen wird--> Client akzeptiert die Verbindung
            connectionToClient = server.accept();
            // Erhalten des Inhalts:
            br = new BufferedReader(new InputStreamReader(connectionToClient.getInputStream()));
            // Ausgeben des Inhalts:
            bw = new BufferedWriter(new OutputStreamWriter(connectionToClient.getOutputStream()));

            bw.write("Hello");
            bw.newLine();
            bw.flush();

            String command;
            while((command = br.readLine()) != null) {
                // Um eine Antwort zu erhalten muss man diese Bedingungen erstellen (so wird kommuniziert)
                if ("TIME".equals(command)) {
                    // Date d = new Date();
                    // bw.write(d.toString());
                    Calendar cal = GregorianCalendar.getInstance();
                    bw.write(cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND));
                    bw.newLine();
                    bw.flush();
                } else if ("PORT".equals(command)) {
                    // Dieser Port gibt die ReportPortNummer aus, zu welchem der Socket verbunden ist
                    // also ein Remoteport am Gerät, von dem gesendet wird
                    bw.write("Port:" + connectionToClient.getPort());
                    bw.newLine();
                    bw.flush();
                } else if ("END".equals(command)) {
                    bw.write("bye");
                    bw.newLine();
                    bw.flush();
                    break;
                } else {
                    bw.write("unknown command");
                    bw.newLine();
                    bw.flush();
                }
            }
            System.out.println("Beendet");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                // alles im finally schließen weil wenn der obere catch auffangen könnte
                // und somit es nicht zum schließen kommt, finally wird ja immer ausgeführt
                br.close();
                bw.close();
                server.close();
                connectionToClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
