package pl.eryk.springbootjunit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

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
}
