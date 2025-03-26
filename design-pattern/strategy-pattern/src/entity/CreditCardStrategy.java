package entity;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println(amount + " paid with credit/debit card");
    }
}
