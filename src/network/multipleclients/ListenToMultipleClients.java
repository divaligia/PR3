package network.multipleclients;
// Hier ist es möglich, mehrere Threads zu erstellen, in denen Server und Client miteinander kommunizieren
// es gibt einen Zeitspalt während dem das Erstellen der Threads möglich ist

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

public class ListenToMultipleClients
{
    public static void main(String[] args)
    {
        ServerSocket server = null;         // server - muss zuerst erstellt werden, weil dieser einen socket erstellt
        Socket connectionToClient = null;    // client - muss die verbindung zum socket akzeptieren
        List<Thread> clients = new ArrayList<Thread>(); // ArrayListe um mehrere Threads zu organisieren
        try
        {
            System.out.println("Starte Server");
            server = new ServerSocket(9090);
            // nach 30 sekunden soll es ein Timeout geben, so lange gibt der server zeit threads zu erstellen
            server.setSoTimeout(30000);
            // Um so viele Verbindungen wie möglich zu erstellen, benutzt man eine Schleife
            while (true)
            {
                try {        // fuer die TimeoutException
                    // Erste Verbindung wird erstellt: Clientsideconnection wird erstellt wenn beim server accept aufgerufen wird
                    connectionToClient = server.accept();
                    // Thread starten und Instanz der Runnable Class übergeben - in diesem Beispiel die CommuncationTask = wie Worker bei Threads
                    Thread t = new Thread(new CommunicationTask(connectionToClient));
                    t.start();
                    // In die AL werden alle Threads hinzugefügt
                    clients.add(t);
                } catch (SocketTimeoutException timeout) {
                    System.out.println("Server has timed out");
                    break;
                }
            }

            // muss außerhalb der while schleife sein um wirklich alle threads fertig werden zu lassen
            for (Thread t : clients)
                t.join();

            System.out.println("Beende Server");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            try{
                server.close();
                connectionToClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}