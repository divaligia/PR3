package fileIO.b_input_output.product;

import java.io.*;
import java.util.ArrayList;

public class ProductManager {
    private ArrayList<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void add(Product p){
        products.add(p);
    }

    public void saveToFile(String path) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));


        for(Product p : products){
            bw.write(p.toString());
            bw.newLine();
            bw.flush();
        }
        System.out.println("Writer done");

    }

    public void readFromFile(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        String line;

        while ((line = br.readLine()) != null){
            System.out.println(line);

        }

        // Datei schließen
        br.close();
        System.out.println("Reader Closed" +
                "");
    }
}
