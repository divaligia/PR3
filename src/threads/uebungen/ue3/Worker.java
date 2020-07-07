package threads.uebungen.ue3;

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
