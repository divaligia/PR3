package threads.bsp2;
/* Schreiben Sie eine Demo-Anwendung, in welcher Sie zwei Threads erzeugen. Einer nimmt
   einen TimePrintWorker auf, einer einen FileReadWorker. Lassen Sie beide Threads gleichzeitig
   laufen und beenden Sie den TimeReadWorker-Thread, sobald die Textdatei eingelesen wurde
   (Tipp: Warten Sie, bis der FileReadWorker beendet ist und bitten Sie im Anschluss
   den TimePrintWorker, sich zu beenden. */

public class WorkerDemo {

    public static void main(String[] args) throws InterruptedException {

        TimePrintWorker timePrintWorker = new TimePrintWorker("TimePrintWorker");
        FileReadWorker fileReadWorker = new FileReadWorker("FileReadWorker",
                "test.txt");
        Thread thread1 = new Thread(timePrintWorker);
        Thread thread2 = new Thread(fileReadWorker);

        thread1.start();
        thread2.start();

        thread2.join();
        timePrintWorker.stopWorker();
        thread1.join();
        System.out.println("Fertig mit allen Arbeiten!");
    }
}
