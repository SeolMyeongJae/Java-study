package interface_.customer;

public class Customer implements Sell, Buy {
    @Override
    public void buy() {
        System.out.println("customer buy");
    }

    @Override
    public void sell() {
        System.out.println("customer sell");
    }

    @Override
    public void order() {
        System.out.println("customer order");
    }

    public void hello() {
        System.out.println("hello");
    }
}
