package pl.eryk.springbootjunit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    public void toArraysShouldBeEquals() {
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        assertArrayEquals(ints1, ints2);
    }

    public void addedMealShouldBeInOrderMeals() {

    }
}
