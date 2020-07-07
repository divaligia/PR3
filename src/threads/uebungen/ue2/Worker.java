package threads.uebungen.ue2;
// Erweitern Sie Ihr „Uhr-Beispiel“, sodass neben der Uhrzeit auch die Anzahl an  CPUs
// und der noch aus Sicht von Java freie Speicher ausgegeben wird:
// ▪ Date d = new Date();
// ▪ System.out.print("[");
// ▪ System.out.print(d.toString());
// ▪ System.out.print(", CPUS: ");
// ▪ System.out.print(Runtime.getRuntime().availableProcessors());
// ▪ System.out.print(", FreeMem: ");
// ▪ System.out.print(Runtime.getRuntime().freeMemory());
// ▪ System.out.print("]");
// Starten Sie zwei „Uhr-Threads“ gleichzeitig
// Entdecken Sie, dass sich die beiden Threads in die Quere kommen?
// Definieren Sie die Ausgabe als „Kritische Sektion“ mit synchronized
// Führen Sie die Anwendung erneut aus und stellen sie fest, dass sich die Threads nicht mehr in die Quere kommen.
import java.sql.SQLOutput;
import java.util.Date;

public class Worker implements Runnable {

    private final int sleepIntervall = 1000;

    private boolean isRunning = true;

    public void requestShutDown(){
        isRunning = false;
    }

    private static Object lock = new Object();

    @Override
    public void run() {
        while (isRunning){
            // synchronized verhindert eine überlappende ausgabe der threads
            synchronized (lock){
                Date d = new Date();
                System.out.print("[");
                System.out.print(Thread.currentThread().getName() + " ");
                System.out.print(d.toString());
                System.out.print(", CPUS: ");
                System.out.print(Runtime.getRuntime().availableProcessors());
                System.out.print(", FreeMem: ");
                System.out.print(Runtime.getRuntime().freeMemory());
                System.out.print("]");
                System.out.println();
                try{
                    Thread.sleep(sleepIntervall);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
