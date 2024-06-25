package br.com.nthing.user;


import jakarta.persistence.Embedded;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDateTime;

public abstract class User {

    private Long id;

    @Embedded
    private UserName name;

    private LocalDateTime birthday;

    @CPF(message = "CPF inválido!")
    @Pattern(regexp = "\\d+", message = "O campo deve conter apenas dígitos numéricos.")
    private String cpf;

    @Embedded
    private Address address;

    @Embedded
    private Phone phone;

    @Email(regexp = "/^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@a-zA-Z0-9?(?:\\\\.a-zA-Z0-9?)*$/")
    private String email;





}
