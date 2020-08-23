package pl.eryk.springbootjunit;

public class Account {
    private String login;
    private boolean active;
    private Address deliveryAddress;
    private AccountType accountType;

    public Account() {
        this.accountType = AccountType.PRIVATE;
    }

    public Account(Address deliveryAddress) {
        if (deliveryAddress != null) {
            this.deliveryAddress = deliveryAddress;
            this.activate();
        }
        this.accountType = AccountType.PRIVATE;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        this.active = true;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
