package pl.eryk.springbootjunit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.eryk.springbootjunit.extensions.MyTestExceptionHanlderExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MealTest {

    @Spy
    Meal mealSpy = spy(Meal.class);

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

    @Test
    public void exceptionShouldBeThrowIfPromotionPriceIsHigherThan100() {
        //given
        Meal meal = new Meal("Pizza", 12);

        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> meal.getPromotionPrice(120));
    }

    @ParameterizedTest
    @ValueSource(ints = { 32, 40 , 70})
    public void mealPricesShouldBeLoweThan100(int price) {
        assertThat(price, lessThan(100));
    }

    @ExtendWith(MyTestExceptionHanlderExtension.class)
    @ParameterizedTest
    @ValueSource(ints = { 32, 40 , 110})
    public void exceptionShouldBeThrowIfPromotionPriceIsHigherThan100WithOwnHandler(int price) {
        if (price > 100) {
            throw new IllegalArgumentException("Price is too big");
        }
        assertThat(price, lessThan(100));
    }

    @Test
    public void priceShouldHasRealValue() {
        //given

        given(mealSpy.getPrice()).willReturn(20.0);

        //when
        double price = mealSpy.getPromotionPrice(10);

        //then
        verify(mealSpy).getPrice();
        assertThat(price, equalTo(2.0));
    }
}
