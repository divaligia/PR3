package threads.uebungen.ue1;
// Schreiben Sie eine Konsolenanwendung mit einem Hintergrund-Thread,
// welcher im Sekundentakt die aktuelle Uhrzeit ausgibt
// Aktuelle Uhrzeit:     Date d = new Date();
// System.out.println(d.toString())
// Per Tastendruck soll die Anwendung (und der Thread „höflich“) gestoppt werden können.

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Worker implements Runnable {

    private final int sleepInterval = 1000; //msec = 1sec;
    private boolean isRunning = true;

    // wird diese Methode aufgerufen, setzt man den boolean auf false und
    // somit wird die while schleife von run unterbrochen und der Prozess wird beendet
    public void requestShutDown(){
        isRunning = false;
    }

    @Override
    public void run() {
        while(isRunning){
            LocalDateTime current = LocalDateTime.now();
            Date currentDate = new Date();
            System.out.println(current.toString());
            try{
                Thread.sleep(sleepInterval);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
