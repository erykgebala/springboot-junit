package pl.eryk.springbootjunit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @Disabled
    @Test
    public void testDisabled() {

    }

    @Test
    @DisplayName("Test large cart orders")
    public void testLargeCartOrders() {
        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(20), cart::simulateLargeOrders);
    }

    @Test
    public void cartShouldNotBeEmptyAfterAddingOrderToCart() {
        //given
        Cart cart = new Cart();
        Order order = new Order();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty()))
        ));

        assertAll(
                () ->notNullValue(),
                () -> hasSize(1),
                () ->is(not(empty()))
        );
    }
}
