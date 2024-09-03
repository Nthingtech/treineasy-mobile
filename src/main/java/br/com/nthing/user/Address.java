package br.com.nthing.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {


    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String district;

    public Address() {
    }

    public Address(String street, String city, String state, String zipCode, String district) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.district = district;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
