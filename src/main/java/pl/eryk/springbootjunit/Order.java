package pl.eryk.springbootjunit;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Meal> meals = new ArrayList<>();

    public void addMealToOrder(Meal meal) {
        meals.add(meal);
    }

    public void removeMealFromOrder(Meal meal) {
        meals.remove(meal);
    }

    public void cancel() {
        this.meals.clear();
    }

    public List<Meal> getMeals() {
        return meals;
    }

    @Override
    public String toString() {
        return "Order{" +
                "meals=" + meals +
                '}';
    }
}
