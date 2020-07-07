package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CommunicateViaSocket {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        try {
            socket = new Socket("www.wetter.at", 80);
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            bw.write("GET /wetter/oesterreich/steiermark/graz/index.html HTTP/1.1");
            bw.newLine();
            bw.write("Host: www.wetter.at");
            bw.newLine();
            bw.newLine();
            bw.flush();

            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("<!DOCTYPE"))
                    break;
                System.out.println(line);
            }

            pw = new PrintWriter("content.html");
            do {
                pw.println(line);
            }
            while ((line = br.readLine()) != null);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pw != null)
                    pw.close();
                if (bw != null)
                    bw.close();
                if (br != null)
                    br.close();
                if (socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}