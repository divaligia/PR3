package threads.example5;
// Es gibt bekanntlich Resourcen, die exklusiv vergeben werden müssen, hierzu gehören u.a.
// Ausgaben auf den Drucker und Schreibzugriffe auf Dateien. Damit ein Thread eine Aufgabe
// exklusiv abarbeiten kann stellt Java das Schlüsselwort synchronized bereit. Betritt ein
// Thread einen Codebereich, der mit synchronized geschützt ist, kann er diesen Bereich exklusiv
// abarbeiten. Kein anderer Thread kann dann diesen Bereich betreten. Dazu hat jedes Javaobjekt
// einen Monitor. Diese Überwachungsinstanz enthält pro Objekt genau einen Lock. Will ein Thread
// einen mit synchronized geschützten Bereich betreten, so muß er vom zugehörigen Objekt einen
// Lock anfordern. Ist dieser bereits vergeben, so muß er warten. Da es nur einen Lock gibt
// sperrt ein Thread, der diesen Lock besitzt zwangsläufig alle anderen mit synchronized
// geschützten Bereiche dieses Objekts. Es werden damit evtl. auch Bereiche gesperrt, die mit der
// von dem Thread gerade abgearbeiteten Code garnichts zu tun haben. Performanceverluste sind die
// logische Folge dieses sozusagen rabiaten Verhalten

import java.util.concurrent.atomic.AtomicInteger;

public class Worker implements Runnable {

    private char sign;
    // kann man statt synchronzier verwenden
    private final AtomicInteger counter = new AtomicInteger(0);
    private final int count = 10;
    private final int sleepIntervall = 10;

    private Konto k1;
    private Konto k2;

    private static Object lock = new Object();
    private static Object lock1 = new Object();

    public Worker(char sign, Konto k1, Konto k2) {
        this.sign = sign;
        this.k1 = k1;
        this.k2 = k2;
    }

    @Override
    public void run() {
        for(int i=0; i<count; i++) {
            // Loest nicht das Critical-Section-Problem aber provoziert einen Deadlock.
            synchronized(k1) {
                synchronized(k2) {
                    double wert1 = k1.getWert();
                    System.out.println(sign + ": Wert von k1 ermittelt");

                    double wert2 = k2.getWert();
                    System.out.println(sign + ": Wert von k2 ermittelt");

                    k1.setWert(wert1 - 10);
                    System.out.println(sign + ": 10 von k1");

                    k2.setWert(wert2 + 10);
                    System.out.println(sign + ": 10 auf k2");
                }
            }

            try {
                Thread.sleep(sleepIntervall);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
