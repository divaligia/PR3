package threads.example2hoeflichstoppen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleHelper {

    public static String readline(){
        InputStreamReader ips = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ips);

//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();

        try{
            return br.readLine();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
