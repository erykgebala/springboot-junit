package pl.eryk.springbootjunit;

import java.util.List;

public interface AccountRepository {

    List<Account> allAccounts();

    void testMethod();
}
