package threads.uebungen.ue1;


public class main {
    public static void main(String[] args) {

        Worker w1 = new Worker();
        Thread t1 = new Thread(w1);
        t1.start();

        System.out.println("Drücken Sie 2x Enter zum Stoppen...");
        if(ConsoleHelper.readLine() != null){
            w1.requestShutDown();
        }
        try{
            t1.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
