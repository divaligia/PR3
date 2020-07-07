package fileIO.binaryinput.product;

import java.io.IOException;

public class ProductDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String path = "pmBinary.txt";
        ProductManager pm = new ProductManager();

        pm.add(new Product("Kaffee", 8.99,"Lebensmittel"));
        pm.add(new Product("Milch", 1.29,"Lebensmittel"));
        pm.add(new Product("Avocado", 3.49,"Lebensmittel"));

        pm.saveToFile(path);
        pm.readFromFile(path);

    }
}
