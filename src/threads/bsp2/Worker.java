package threads.bsp2;

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
