package pl.eryk.springbootjunit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnPromotionPrice() {
        //given
        Meal meal = new Meal("Pizza", 12);

        //when
        double promotionPrice = meal.getPromotionPrice(50);

        //then
        assertEquals(promotionPrice, 6);
    }

    @Test
    void objectWithTheSamePriceShouldBeEqual() {
        //given
        Meal meal1 = new Meal("Pizza", 12);
        Meal meal2 = new Meal("Pizza", 12);

        //when
        //then
        assertEquals(meal1, meal2);
        Assertions.assertThat(meal1).isEqualTo(meal2);
    }
}
