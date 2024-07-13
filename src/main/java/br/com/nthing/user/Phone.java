package br.com.nthing.user;

import jakarta.persistence.Embeddable;

@Embeddable
public class Phone {

    private String number;
    private String type;
    private String country;
    private String areaCode;

    public Phone() {
    }

    public Phone(String number, String type, String country, String areaCode) {
        this.number = number;
        this.type = type;
        this.country = country;
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}
