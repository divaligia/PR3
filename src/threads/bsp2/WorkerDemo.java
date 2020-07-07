package threads.bsp2;

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
