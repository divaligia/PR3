package fileIO.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CatchInsideFinally {
    public static void main(String[] args) {
        catchInsideFinally("umlafuft.txt");
    }

    private static void catchInsideFinally(String fileName){
        //Declare here to be visible from finally block
        BufferedReader bufferedReader = null;
        try{
            // if line fails, finally will be executed and reader will be null
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while((line = bufferedReader.readLine()) != null){
                // process the line..
            }
     } catch (IOException ex){
            ex.printStackTrace();
        } finally {
            try{
                // need to check for null
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
}
