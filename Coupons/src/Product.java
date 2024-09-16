public abstract class Product {
    private String productId;
    private String productName;
    private double price;
    private ProductType productType;

    protected Product() {

    }

    protected Product(String productId, String productName, int price, ProductType productType) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productType = productType;
    }

    public double getPrice() {
        return price;
    }
}
