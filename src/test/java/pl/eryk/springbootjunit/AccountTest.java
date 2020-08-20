package pl.eryk.springbootjunit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


class AccountTest {

    @Test
    public void accountShouldBeNoActiveWihoutActivate() {
        //given
        Account account = new Account();

        //when
        //then
        assertFalse(account.isActive());                        //junit
        assertThat(account.isActive(), equalTo(false));  //hamcrest
        assertThat(account.isActive(), is(false));  //hamcrest
        Assertions.assertThat(account.isActive()).isFalse();  //assertj
    }

    @Test
    public void accountShouldBeActiveAfterActivate() {
        //given
        Account account = new Account();

        //when
        account.activate();

        //then
        assertTrue(account.isActive());
        assertThat(account.isActive(), equalTo(true));  //hamcrest
        assertThat(account.isActive(), is(true));  //hamcrest
        Assertions.assertThat(account.isActive()).isTrue();  //assertj
    }

    @Test
    public void referenceToTheSameObjectShouldBeEqual()  {
        //given
        Account account = new Account();
        Account account2 = account;

        //when
        //then
        assertSame(account, account2);
        assertThat(account, sameInstance(account2));        //hamcrest
        Assertions.assertThat(account).isSameAs(account2);  //assertj
    }

    @Test
    public void referenceToDiffObjectShouldBeNotEqual()  {
        //given
        Account account = new Account();
        Account account2 = new Account();

        //when
        //then
        assertNotSame(account, account2);
        assertThat(account, not(sameInstance(account2)));   //hamcrest
        Assertions.assertThat(account).isNotSameAs(account2);  //assertj
    }

    @Test
    public void newAccountShouldHaveNullDeliveryAdress() {
        //given
        Account account = new Account();

        //when
        Address address = account.getDeliveryAddress();

        //then
        assertNull(address);
        assertThat(address, nullValue());   //hamcrest
        Assertions.assertThat(address).isNull();  //assertj
    }

    @Test
    public void deliveryAddressShouldNotBeingNullAfterSet() {
        //given
        Account account = new Account();
        account.setDeliveryAddress(new Address("Polna", "Warszawa", "12"));

        //when
        Address address = account.getDeliveryAddress();

        //then
        assertNotNull(address);
        assertThat(address, is(notNullValue()));    //hamcrest
        Assertions.assertThat(address).isNotNull();  //assertj
    }
}
