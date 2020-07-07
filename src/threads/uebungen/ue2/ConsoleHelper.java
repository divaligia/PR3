package threads.uebungen.ue2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static String readline(){
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        try{
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
