package pl.eryk.springbootjunit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;

class AccountServiceWithStubTest {

    @Test
    void allAccountsShouldBePrivateType() {
        //given
        AccountRepository accountRepository = new AccountRepositoryStub();
        AccountService accountService = new AccountService(accountRepository);

        //when
        List<Account> allPrivateAccount = accountService.getAllPrivateAccount();

        //then
        assertThat(allPrivateAccount, hasSize(3));
    }

    private static class AccountRepositoryStub implements AccountRepository {
        @Override
        public List<Account> allAccounts() {
            Account account1 = new Account();
            Account account2 = new Account();
            Account account3 = new Account();

            return Arrays.asList(account1, account2, account3);
        }

        @Override
        public void testMethod() {

        }
    }
}
