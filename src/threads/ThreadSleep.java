package threads;

// Anstelle von implements runnable wird diese Klasse von Thread abgeleitet
// runnable wird hier nicht benötigt, weil das Objekt Thread erstellt wird
// man braucht trotzdem die run methode um anzugeben, was der thread machen soll

public class ThreadSleep extends Thread{

    public void run(){
        for(int i = 1; i < 5; i++){
            try{
     // Thread wird alle 2 sek ausgeführt (hier muss er 2000 Millisek heia gehen)
                Thread.sleep(2000);
            } catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        /*         When the run method gets called though start() method
        then a new separate thread is being allocated to the execution of
        run method, so if more than one thread calls start() method that
        means their run method is being executed by separate threads (these
        threads run simultaneously).
         */
        ThreadSleep ts1 = new ThreadSleep();
        ThreadSleep ts2 = new ThreadSleep();

        ts1.start();
        ts2.start();
    }
}
