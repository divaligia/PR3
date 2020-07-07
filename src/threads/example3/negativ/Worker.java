package threads.example3.negativ;

public class Worker implements Runnable {

    private char sign;

    private final int count = 10;
    private final int sleepIntervall = 10;

    private Konto k1;
    private Konto k2;

    public Worker(char sign, Konto k1, Konto k2){
        this.sign = sign;
        this.k1 = k1;
        this.k2 = k2;
    }

    @Override
    public void run(){
        for(int i = 0; i < count; i++){

            double wert1 = k1.getWert();
            System.out.println(sign + ": Wert von k1 ermittelt");

            double wert2 = k2.getWert();
            System.out.println(sign + ": Wert von k2 ermittelt");

            k1.setWert(wert1 - 10);
            System.out.println(sign + ": 10 von k1");

            k1.setWert(wert2 + 10);
            System.out.println(sign + ": 10 auf k2");

            try{
                Thread.sleep(sleepIntervall);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
