import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> productList;

    public Cart() {
        productList = new ArrayList<>();
    }


    public void removeProduct(Product product) {
        productList.remove(product);
    }

    public void addProduct(Product product) {
        Product productAdded = new PercentageDiscountCoupon(new FixedDiscountCoupon(product, 5), 10);
        productList.add(productAdded);
    }

    public double getTotalCost() {
        double cost = 0.0;
        for (Product product : productList) {
            cost += product.getPrice();
        }
        return cost;
    }

}
