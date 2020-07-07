package threads.example1;


public class Worker implements Runnable {

    private char sign;

    public Worker(char sign){
        this.sign = sign;
    }


    // in der run methode wird festgelegt, was ein Thread ausführen soll
    // hier soll 100x der char ausgegeben werden
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + Thread.currentThread().getName() + " " + sign);
            try {
    // sleep() wird verwendet um das Ausführen des aktuellen Threads
    // um die Anzahl an millisec zu pausieren
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
