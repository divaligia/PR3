package threads.uebungen.ue3;
// Schreiben Sie eine einfache Klasse, welche Runnable implementiert und innerhalb
// der run()Methode einen statischen Counter der Klasse erhöht. Pro Sekunde soll
// einmal der Counter erhöht werden Bis die Zahl 20 erreicht ist
// Erstellen Sie zwei Thread-Instanzen auf einem Worker
// Behandeln Sie den Counter als „Kritische Sektion“ mit synchronized
// Stellen Sie sicher, dass am Ende das richtige Ergebnis herauskommt (Counter muss 20 sein)
// Geben Sie parallel auf der Console den Threadnamen sowie den aktuellen Counter Wert aus. (In der Run Methode)

// Auf diese weise wird die Zählarbeit nur von einem Thread ausgeführt

public class Worker implements Runnable {

    private final int sleepIntervall = 100;
    private int counter = 0;
    private static Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock){
            while (counter < 21){
                System.out.println(Thread.currentThread().getName() + " Counter   ---   " + counter++);
                try{
                    Thread.sleep(sleepIntervall);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
