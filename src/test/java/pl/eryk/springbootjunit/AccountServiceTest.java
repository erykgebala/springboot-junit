package pl.eryk.springbootjunit;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Test
    void allAccountsShouldBePrivateType() {
        //given
        List<Account> accounts = preparePrivateAccounts();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.allAccounts()).thenReturn(accounts);
        //given(accountRepository.allAccounts()).willReturn(accounts); --BDD

        //when
        List<Account> allPrivateAccount = accountService.getAllPrivateAccount();

        //then
        assertThat(allPrivateAccount, hasSize(3));
        verify(accountRepository).allAccounts();
        verify(accountRepository, times(1)).allAccounts();
        verify(accountRepository, atLeastOnce()).allAccounts();

        //kolejnosc wywolania metod z mocka
        InOrder inOrder = inOrder(accountRepository);
        inOrder.verify(accountRepository).allAccounts();
        inOrder.verify(accountRepository).testMethod(ArgumentMatchers.any(Account.class));
    }

    @Test
    void allAccountsShouldBePrivateTypeWithArgCaptor() {
        //given
        List<Account> accounts = preparePrivateAccounts();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService accountService = new AccountService(accountRepository);
        when(accountRepository.allAccounts()).thenReturn(accounts);

        ArgumentCaptor<Account> accountArgumentCaptor = ArgumentCaptor.forClass(Account.class);

        //when
        List<Account> allPrivateAccount = accountService.getAllPrivateAccount();

        //then
        verify(accountRepository).testMethod(accountArgumentCaptor.capture());
        assertThat(accountArgumentCaptor.getValue().getAccountType(), equalTo(AccountType.PRIVATE));
    }

    public List<Account> preparePrivateAccounts() {
        Account account1 = new Account();
        Account account2 = new Account();
        Account account3 = new Account();

        return Arrays.asList(account1, account2, account3);
    }


}
