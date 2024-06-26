package br.com.nthing.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "tbl_user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Client extends User{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_client")
    private Long id;

    public Client(UserName name, LocalDateTime birthday, String cpf, Address address, Phone phone, String email, Gender gender, Long id) {
        super(name, birthday, cpf, address, phone, email, gender);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
                ", name=" + name +
                ", birthday=" + birthday +
                ", cpf='" + cpf + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", dtRegister=" + dtRegister +
                "} " + super.toString();
    }
}
