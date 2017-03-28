package de.bhtb.external.data.dao.entities;

/**
 * Created by visenger on 28/03/17.
 */
public class Customer {
    int customerNumber;
    String name;
    String streetAddress;
    String city;

    public Customer(int customerNumber, String name) {
        this.customerNumber = customerNumber;
        this.name = name;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
