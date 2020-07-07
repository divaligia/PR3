package fileIO.b_input_output.binaryoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteBinaryData {
    public static void main(String[] args) throws IOException {
        File f = new File("binaryOutput.txt");
        FileOutputStream fos = new FileOutputStream(f);

        char c;

        // solange kein x eingegeben wird, werden die Chars ausgegeben
        while((c = (char) System.in.read()) != 'x'){
            fos.write(c);
            System.out.println(c);
        }
        fos.flush();
        fos.close();
        System.out.println("Closed");
    }
}
