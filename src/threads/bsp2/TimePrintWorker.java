package threads.bsp2;
/* Erstellen Sie eine konkrete Implementierung des Workers mit dem Namen TimePrintWorker
   und implementieren Sie das Interface Runnable. In der Methode work() soll nun solange
   shouldRun auf true gesetzt ist, jede Sekunde die aktuelle Uhrzeit ausgegeben werden.
   Rufen Sie zu Beginn und Ende von work() jeweils die Methoden printStarted() und
   printStopped() auf. Rufen Sie die Methode work() in der Methode run() auf.
   Die aktuelle Uhrzeit können Sie mit folgenden Codezeilen ausgeben:
   Date d = new Date(); System.out.println(d.toString()); */


import java.util.Date;

public class TimePrintWorker extends Worker {


    @Override
    public void run() {
        printStarted();
        while (shouldRun) {
            try {
                work();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printStopped();
    }

    public TimePrintWorker(String name) {
        super(name);
    }

    @Override
    protected void work() throws InterruptedException {
        Date d = new Date();
        System.out.println(d.toString());
        Thread.sleep(1000);
    }
}
