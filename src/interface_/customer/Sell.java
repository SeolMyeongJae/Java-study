package interface_.customer;

public interface Sell {
    void sell();

    default void order() {
        System.out.println("sell order ");
    }
}
