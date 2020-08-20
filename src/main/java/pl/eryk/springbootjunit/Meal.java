package pl.eryk.springbootjunit;

import java.util.Objects;

public class Meal {

    final private String name;
    final private double price;

    public Meal(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPromotionPrice(double promotionPercent) {
        return (promotionPercent * price) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Meal meal = (Meal) o;
        return Double.compare(meal.price, price) == 0 &&
                Objects.equals(name, meal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
