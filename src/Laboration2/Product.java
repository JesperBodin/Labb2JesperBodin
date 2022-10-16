package Laboration2;


import java.util.Objects;

public class Product {

    private String category;
    private  String name;
    private double price;
    private final String brand;
    private final String productId;
    private int balance;

    public Product(String category, String name, double price,
                   String brand, String productId, int balance) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.productId = productId;
        this.balance = balance;
    }


    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getBrand() {
        return brand;
    }
    public String getProductId() {
        return productId;
    }
    public int getBalance() {
        return balance;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product that = (Product) o;
        return price == that.price && balance == that.balance && Objects.equals(category, that.category) && Objects.equals(name, that.name) && Objects.equals(brand, that.brand) && Objects.equals(productId, that.productId);
    }
    @Override
    public int hashCode() {
        return Objects.hash(category, name, price, brand, productId, balance);
    }
    @Override
    public String toString() {
        return "[Category]: " + category +
                " [Product name]: " + name +
                " [Price]: " + price + "kr"+
                " [Brand]: " + brand +
                " [EAN]: " + productId +
                " [Balance]: " + balance +
                "pcs";
    }
}


