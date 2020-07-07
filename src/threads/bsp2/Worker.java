package threads.bsp2;
/* Schreiben Sie eine Klasse Worker, mit dem einem Attribut protected String name
   und einem Attribut protected boolean shouldRun. Im Konstruktor wird der Name des
   Workers übernommen, sowie shouldRun auf true gesetzt. Die Klasse hat eine abstrakte
   Methode protected void work(). Erstellen Sie eine Methode protected void printStarted(),
   welche auf der Konsole den Namen des Workers, sowie „wurde gestartet“ ausgibt. Erstellen
   Sie eine weitere Methode protected void printStopped(), welche auf der Konsole den Namen
   des Workers, sowie „wurde gestoppt“ ausgibt. Schreiben Sie eine öffentliche Methode public
   void stopWorker(), welche shouldRun auf false setzt.  */

import java.io.IOException;

public abstract class Worker implements Runnable{

    protected String name;
    protected boolean shouldRun;

    public Worker(String name) {
        this.name = name;
        this.shouldRun = true;
    }

    // Wenn abstrakte Methode erstellt werden muss, kann es sich nur um abstrakte Klasse handeln
    protected abstract void work() throws InterruptedException, IOException;

    protected void printStarted(){
        System.out.println(name + " wurde gestartet!");
    }

    protected void printStopped(){
        System.out.println(name + " wurde gestoppt!");
    }

    public void stopWorker(){
        this.shouldRun = false;
    }
}
