package fileIO.b_input_output.binaryoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryIO_Ue1 {
    public static void main(String[] args) throws IOException {
        File f = new File("test-output.txt");
        FileOutputStream fos = new FileOutputStream(f);

        String oText = "Hello File - first output";
        for (char c : oText.toCharArray()) {
            fos.write(c);
        }
        fos.flush();
        fos.close();
    }
}
