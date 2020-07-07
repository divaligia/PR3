package threads.uebungen.ue1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleHelper {

    public static String readLine(){
       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(isr);

        Scanner in = new Scanner(System.in);
        String s = in.nextLine();

        try{
            return br.readLine();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
