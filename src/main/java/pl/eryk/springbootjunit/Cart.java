package pl.eryk.springbootjunit;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders = new ArrayList<>();

    public void addOrderToCart(Order order) {
        this.orders.add(order);
    }

    public void removeOrderFromCart(Order order) {
        this.orders.remove(order);
    }

    public void clearCart() {
        this.orders.clear();
    }

    public void simulateLargeOrders() {
        for (int i = 0; i < 10000; i++) {
            Meal meal = new Meal("Pizza" + i, i%12);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);
        }
    }
}
