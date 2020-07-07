package fileIO.binaryinput.product;

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
