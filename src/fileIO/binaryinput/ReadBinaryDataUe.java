package fileIO.binaryinput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryDataUe {
    public static void main(String[] args) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("binaryOutput.txt"));

        int byteRead;
        while((byteRead = bis.read()) != -1){
            System.out.println((char) byteRead);
        }

        bis.close();
    }
}
