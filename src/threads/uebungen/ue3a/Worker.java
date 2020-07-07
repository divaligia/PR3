package threads.uebungen.ue3a;

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
