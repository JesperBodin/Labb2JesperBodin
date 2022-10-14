package Laboration2;


import java.util.Objects;

public class Product {

    private final String category;
    private final String name;
    private final double price;
    private final String brand;
    private  final String productId;
    private final int balance;

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


