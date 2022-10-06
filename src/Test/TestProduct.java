package Test;


import java.util.Objects;

public class TestProduct {
    private final String categoryName;
    private final String product;
    private final double price;
    private final int productId;

    public TestProduct(String categoryName, String Product, double price, int productId) {
        this.categoryName = categoryName;
        this.product = Product;
        this.price = price;
        this.productId = productId;
    }

    public String categoryName() {
        return categoryName;
    }

    public String Product() {
        return product;
    }

    public double price() {
        return price;
    }

    public int productId() {
        return productId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (TestProduct) obj;
        return Objects.equals(this.categoryName, that.categoryName) &&
                Objects.equals(this.product, that.product) &&
                Double.doubleToLongBits(this.price) == Double.doubleToLongBits(that.price) &&
                this.productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, product, price, productId);
    }

    @Override
    public String toString() {
        return "TestProductCategory[" +
                "categoryName=" + categoryName + ", " +
                "Product=" + product + ", " +
                "price=" + price + ", " +
                "productId=" + productId + ']';
    }

}
