package threads;

// Damit der Thread weiß, was er ausführen soll, müssen wir ihm Anweisungsfolgen geben.
// Diese werden in einem Befehlsobjekt vom Typ Runnable verpackt und dem Thread übergeben.
// Wird der Thread gestartet, arbeitet er die Programmzeilen aus dem Befehlsobjekt parallel
// zum restlichen Programmcode ab. Die Schnittstelle Runnable ist schmal und schreibt nur eine run()-Methode vor.

public class RunnableExample implements Runnable {

    public static void main(String[] args) {
        System.out.println("Inside: " + Thread.currentThread().getName());

        // Objekt runnable erstellen um es dann in einen Thread zu legen
        System.out.println("Creating Runnable...");
        Runnable runnable = new RunnableExample();

        System.out.println("Creating Thread...");
        Thread thread = new Thread(runnable);
        // Thread umbenennen:
        thread.setName("neu");
        System.out.println(thread.getName());

        // Mit der .start() methode wird die run methode aufgerufen
        System.out.println("Starting Thread");
        thread.start();
    }

    public void run(){
        System.out.println("Inside new Thread: " + Thread.currentThread().getName());
    }
}
