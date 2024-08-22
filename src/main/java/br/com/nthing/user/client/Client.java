package br.com.nthing.user.client;

import br.com.nthing.user.Address;
import br.com.nthing.user.Gender;
import br.com.nthing.user.Phone;
import br.com.nthing.user.User;
import br.com.nthing.user.UserName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_user", indexes = {@Index(columnList = "instagram")})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_client")
    private Long id;

    @Column(name = "instagram")
    private String instagram;

    public Client() {

    }

    public Client(UserName name, LocalDate birthday, Integer age, String cpf, Address address, Phone phone, String email, Gender gender, LocalDateTime dtRegister, Long id, String instagram) {
        super(name, birthday, age, cpf, address, phone, email, gender, dtRegister);
        this.id = id;
        this.instagram = instagram;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", instagram='" + instagram + '\'' +
                ", name=" + name +
                ", birthday=" + birthday +
                ", age=" + age +
                ", cpf='" + cpf + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dtRegister=" + dtRegister +
                "} " + super.toString();
    }
}
