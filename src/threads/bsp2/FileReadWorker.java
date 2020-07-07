package threads.bsp2;



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
