public class Main {
    public static void main(String[] args) {
        Cart cart=new Cart();
        Item1 item1=new Item1("1","phone",105);
        Item2 item2=new Item2("2","tie",100);
        cart.addProduct(item1);
        cart.addProduct(item2);
        System.out.println(cart.getTotalCost());
        System.out.println("Hello world!");
    }
}