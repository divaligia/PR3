package threads.example1;

import threads.ThreadExample;

public class WorkerDemo {
    public static void main(String[] args) throws InterruptedException {

        // neuen Worker anlegen
        Runnable worker1 = new Worker('A');
        Runnable worker2 = new Worker('B');

        Thread t1 = new Thread(worker1);
        Thread t2 = new Thread(worker2);

        t1.start();
        t2.start();
        System.out.println("t1: " + t1.getName());
        System.out.println("t2: " + t2.getName());
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        // join() wartet bis thread fertig ist, erst dann wird "Done" ausgegeben
        t1.join();
        t1.join();

        System.out.println("Done");
    }
}