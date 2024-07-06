package br.com.nthing.user;


import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class User {


    @Embedded
    @Column(name = "user_name")
    protected UserName name;

    @Column(name = "birthday", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    protected LocalDateTime birthday;

    @CPF
    @Pattern(regexp = "\\d+", message = "O campo deve conter apenas dígitos numéricos.")
    @Column(name = "cpf")
    protected String cpf;

    @Embedded
    @Column(name = "address")
    protected Address address;

    @Embedded
    @Column(name = "phone")
    protected Phone phone;

    @Email
    @Column(name = "email")
    protected String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    protected Gender gender;

    @Column(name = "dt_register", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    protected final LocalDateTime dtRegister = LocalDateTime.now();


    public User() {
    }

    public User(UserName name, LocalDateTime birthday, String cpf, Address address, Phone phone, String email, Gender gender) {
        this.name = name;
        this.birthday = birthday;
        this.cpf = cpf;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
    }

    public UserName getName() {
        return name;
    }

    public void setName(UserName name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public @CPF @Pattern(regexp = "\\d+", message = "O campo deve conter apenas dígitos numéricos.") String getCpf() {
        return cpf;
    }

    public void setCpf(@CPF @Pattern(regexp = "\\d+", message = "O campo deve conter apenas dígitos numéricos.") String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDateTime getDtRegister() {
        return dtRegister;
    }

    @Override
    public String toString() {
        return "User{" +
                "name=" + name +
                ", birthday=" + birthday +
                ", cpf='" + cpf + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}
