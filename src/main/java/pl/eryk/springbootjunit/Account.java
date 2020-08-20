package pl.eryk.springbootjunit;

public class Account {
    private String login;
    private boolean active;
    private Address deliveryAddress;

    public Account() {
    }

    public Account(Address deliveryAddress) {
        if (deliveryAddress != null) {
            this.deliveryAddress = deliveryAddress;
            this.activate();
        }
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
}
