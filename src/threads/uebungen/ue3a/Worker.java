package threads.uebungen.ue3a;
// Erweitern Sie das vorherige Beispiel so, dass abwechselnd Threads eingesetz werden.
// Tipp: Verwenden Sie die Methoden: wait() sowie notify()
// * notify Wakes up all threads that are waiting on this object's monitor. A
//     * thread waits on an object's monitor by calling one of the methods.

//     * So führen die Threads die Zählarbeit abwechselnd aus

public class Worker implements Runnable{

    private final int sleepIntervall = 100;
    private int counter = 0;
    private static Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock){
            while(counter < 21){
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() +
                        " Counter    ---    " + counter++);
                try{
                    Thread.sleep(sleepIntervall);
                    lock.wait();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            } lock.notifyAll();      // Releases all waiting Threads
        }
    }
}
