package threads.bsp2;

/* Erstellen Sie eine weitere konkrete Implementierung des Workers mit dem Name
   FileReadWorker und implementieren Sie das Interface Runnable. Übernehmen Sie
   zusätzlich im Konstruktor einen Wert für das neue Attribut private String path,
   welches den Pfad zu einer Textdatei abbildet. Erstellen Sie ein weiteres Attribut
   public ArrayList<String> lines, in welcher die eingelesen Textzeilen gespeichert
   werden sollen. Laden Sie in der Methode work() die angegebene Textdatei und
   speichern Sie die eingelesenen Textzeilen in der ArrayList. Überprüfen Sie auch
   nach jedem Lesevorgang, ob shouldRun noch immer true ist und brechen Sie gegebenenfalls ab.
    Für Tests können Sie den Lesevorgang auch verzögern, in dem Sie ein Thread.sleep() einbauen.
    Rufen Sie zu Beginn und Ende von work() jeweils die Methoden printStarted()
    und printStopped() auf. Rufen Sie die Methode work() in der Methode run() auf.   */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReadWorker extends Worker {

    private String path;
    public ArrayList<String> lines;

    public FileReadWorker(String name, String path) {
        super(name);
        this.path = path;
        lines = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            printStarted();
            work();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        printStopped();
    }


    @Override
    protected void work() throws InterruptedException, IOException {
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);
        String templine;

        while ((templine = br.readLine()) != null) {
            if (!shouldRun)
                break;
            lines.add(templine);
            System.out.println(templine);
            Thread.sleep(1000);
        }
        br.close();
    }
}
