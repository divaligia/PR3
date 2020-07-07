package fileIO.b_input_output.product;

import java.io.IOException;

public class ProductMain {
    public static void main(String[] args) throws IOException {

        ProductManager pm = new ProductManager();

        pm.add(new Product("Kaffee", 8.99, "Lebensmittel"));
        pm.add(new Product("Milch", 1.20, "Lebensmittel"));
        pm.add(new Product("Gurke", 0.99, "Lebensmittel"));
        pm.add(new Product("Maiswaffeln", 1.39, "Lebensmittel"));
        pm.add(new Product("Tomate", 8.99, "Lebensmittel"));

        pm.saveToFile("produkte.txt");
        pm.readFromFile("produkte.txt");
    }
}
