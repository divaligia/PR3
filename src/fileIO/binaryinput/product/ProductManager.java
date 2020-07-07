package fileIO.binaryinput.product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    public ProductManager() {
        this.products = new ArrayList<>();
    }

    public void add(Product p){
        products.add(p);
    }

    public void saveToFile(String path) throws IOException {
        File f = new File(path);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream((fos));

        for(Product p : products){
            oos.writeObject(p);
        }
        oos.flush();
        oos.close();
        System.out.println("Done saving");
    }

    public void readFromFile(String path) throws IOException, ClassNotFoundException {

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        List<Product> products = new ArrayList<>();
        Boolean cont = true;

        while(cont){
            try{
                Product p = (Product) ois.readObject();
                System.out.println(p);
                if(p != null) {
                    products.add(p);
                } else {
                    cont = false;
                }
            } catch (EOFException e) {
                break;
            }
        }
        System.out.println("Read Object data: ");
        System.out.println(products);
        ois.close();
    }
}
