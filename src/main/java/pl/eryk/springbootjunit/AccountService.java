package pl.eryk.springbootjunit;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllPrivateAccount() {
        List<Account> collect = this.accountRepository.allAccounts().stream()
                .filter((a -> a.getAccountType().equals(AccountType.PRIVATE)))
                .collect(Collectors.toList());
        this.accountRepository.testMethod(new Account());
        return collect;
    }
}
