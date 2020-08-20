package pl.eryk.springbootjunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    private Order order;

    @BeforeEach
    void initializaOrder() {
        this.order = new Order();
    }

    @AfterEach
    void cleanOrder() {
        this.order.cancel();
    }

    @Test
    public void toArraysShouldBeEquals() {
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        assertArrayEquals(ints1, ints2);
    }

    @Test
    public void orderMealsShouldNotBeEmptyAfterAddingMealToOrder() {
        //given
        Meal meal = new Meal("Pizza", 34);

        //when
        order.addMealToOrder(meal);

        //then
        assertEquals(order.getMeals().size(), 1);
        assertThat(order.getMeals(), not(empty()));             //hamcrest
        assertThat(order.getMeals().size(), equalTo(1));//hamcrest
        assertThat(order.getMeals(), hasSize(1));//hamcrest
        assertThat(order.getMeals(), not(emptyCollectionOf(Meal.class)));//hamcrest
        assertThat(order.getMeals(), contains(meal));//hamcrest
        assertThat(order.getMeals(), hasItem(meal));//hamcrest
        assertThat(order.getMeals().get(0).getPrice(), equalTo(34.0));//hamcrest

    }

    @Test
    public void orderMealsShouldBeInCorrectOrder() {
        //given
        Meal pizza = new Meal("Pizza", 34);
        Meal burger = new Meal("Burger", 25);

        //when
        order.addMealToOrder(pizza);
        order.addMealToOrder(burger);

        //then
        assertThat(order.getMeals(), contains(pizza, burger));
        assertThat(order.getMeals(), containsInAnyOrder(burger, pizza));

    }
}
