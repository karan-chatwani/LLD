public class FixedDiscountCoupon extends CouponDecorator {
    private Product product;
    int discount;

    public FixedDiscountCoupon(Product product, int discount) {
        this.product = product;
        this.discount = discount;
    }

//    @Override
    public double getPrice() {
        return product.getPrice() - discount;
    }
}
