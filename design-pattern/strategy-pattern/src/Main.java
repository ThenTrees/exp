import entity.CreditCardStrategy;
import entity.Item;
import entity.PaypalStrategy;
import entity.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        Item item1 = new Item("1234", 10);
        Item item2 = new Item("5678", 40);
        shoppingCart.addItem(item1);
        shoppingCart.addItem(item2);

        // if have more than 1 payment method, we can change the payment method here
        shoppingCart.pay(new PaypalStrategy());
        shoppingCart.pay(new CreditCardStrategy());
    }
}