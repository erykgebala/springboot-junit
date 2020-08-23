package pl.eryk.springbootjunit;

import java.util.List;

public interface AccountRepository {

    List<Account> allAccounts();

    boolean testMethod(Account account);
}
