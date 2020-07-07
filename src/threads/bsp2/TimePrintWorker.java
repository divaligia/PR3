package threads.bsp2;

import threads.bsp2.Worker;

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
