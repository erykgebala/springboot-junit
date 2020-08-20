package pl.eryk.springbootjunit;

public class Address {
    private String street;
    private String city;
    private String flatNumber;

    public Address(String street, String city, String flatNumber) {
        this.street = street;
        this.city = city;
        this.flatNumber = flatNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }
}
