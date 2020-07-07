package fileIO.binaryinput.product;

// Schreiben Sie eine Klasse Product zur Abbildung von Produkten mit folgenden Attributen.
// ▪ String ProductName ▪ Double Price ▪ String ProductCategory
// Schreiben Sie eine Klasse ProductManagerzum Verwalten von Produkten in einer privaten Liste
// und implementieren Sie folgende Methoden ▪ public void add(Product p) ➔fügt ein Produkt hinzu
// ▪ public void save(String path) ➔speichert die Produkte in der übergebenen Datei.
// Realisieren Sie dies mittels ObjectOutputSteam. Kombinieren Sie den ObjectOutputStream mit
// einem BufferedOutputStream.
// ▪ public void load(String path) ➔laden Sie die Produkte von der übergebenen Datei

import java.io.Serializable;

public class Product implements Serializable {
    public String productname;
    protected Double price;
    public String productcategory;

    public Product(String productname, Double price, String productcategory) {
        this.productname = productname;
        this.price = price;
        this.productcategory = productcategory;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setProductcategory(String productcategory) {
        this.productcategory = productcategory;
    }

    public String getProductname() {
        return productname;
    }

    public double getPrice() {
        return price;
    }

    public String getProductcategory() {
        return productcategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productname='" + productname + '\'' +
                ", price=" + price +
                ", productcategory='" + productcategory + '\'' +
                '}';
    }
}
