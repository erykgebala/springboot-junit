package pl.eryk.springbootjunit;

import java.util.Objects;

public class Meal {

    private String name;
    private double price;

    public Meal() {
    }

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
        if (promotionPercent > 100) {
            throw new IllegalArgumentException("Promotion percent should be lower than 100");
        }
        return (promotionPercent * getPrice()) / 100;
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

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
