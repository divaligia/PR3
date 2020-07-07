package fileIO.umlaute;

import java.io.*;
import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;

public class CodierteTextdateienLesenUe {

    public static void main(String[] args) throws IOException {

        writeFile("umlaute2.txt", UTF_8);
        readFile("umlaute2.txt", UTF_8);

    }

    public static void writeFile(String filePath, Charset encoding) throws IOException {
        // File und BufferedWriter außerhalb des try/catch erstellen da sie
        // innerhalb der {} Klammern lokale Variablen wären (dh nur innerhalb
        // dieser genutzt werden können.)
        BufferedWriter bw = null;
        File file = new File (filePath);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter os = new OutputStreamWriter(fos);
            bw = new BufferedWriter(os);
            bw.write("Köche kochen Äpfel");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bw != null){
                bw.flush();
                bw.close();
                System.out.println("Done!");
            }
        }
    }

    public static void readFile(String path, Charset encoding){
        File f = new File(path);
        try{
            FileReader fr = new FileReader(f, encoding);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
