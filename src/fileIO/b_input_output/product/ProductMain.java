package fileIO.b_input_output.product;
// Schreiben Sie eine Klasse Productzur Abbildung von Produkten mit folgenden Attributen.
// ▪ String ProductName ▪ Double Price ▪ String ProductCategory
// Schreiben Sie eine Klasse ProductManagerzum Verwalten von Produkten in einer privaten Liste
// und implementieren Sie folgende Methoden ▪ public void add(Product p) ➔fügt ein Produkt hinzu
// ▪ public void saveToFile(String path) ➔speichert die Produkte in der übergebenen Datei.
// - Realisieren Sie dies mittels BufferedWriter und Filewriter.
// ▪ public void readFromFile(String path)
// ➔laden Sie den Text von der übergebenen Datei und geben Sie den Text auf der Konsole aus.
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
