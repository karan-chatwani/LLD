public class PercentageDiscountCoupon extends CouponDecorator {
    private Product product;
    int discountPercent;

    public PercentageDiscountCoupon(Product product, int discountPercent) {
        this.product = product;
        this.discountPercent = discountPercent;
    }

//    @Override
    public double getPrice() {
        double off = (discountPercent * product.getPrice() * 1.0) / 100;
        return product.getPrice() - off;
    }
}
