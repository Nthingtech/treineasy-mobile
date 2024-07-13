package br.com.nthing.user.client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

    public List<Client> findByFirstOrLast(String fullName) {
        return list("lower(name.firstName) like lower(?1) or lower(name.lastName) like lower(?1)", "%" + fullName + "%");
    }

    public int updateClient(Client client) {
        return update("UPDATE Client c SET c.instagram = :instagram, c.name.firstName = :name.firstName, c.name.lastName = :name.lastName, c.birthday = :birthday, c.cpf = :cpf, c.address.street = :address.street, c.address.city = :address.city, c.address.state = :address.state, c.address.zipCode = :address.zipCode, c.address.district = :address.district, c.phone.number = :phone.number, c.phone.type = :phone.type, c.phone.country = :phone.country, c.phone.areaCode = :phone.areaCode, c.email = :email, c.gender = :gender WHERE c.id = :id",
                Parameters.with("instagram", client.getInstagram())
                        .and("name.firstName", client.getName().getFirstName())
                        .and("name.lastNme", client.getName().getLastName())
                        .and("birthday", client.getBirthday())
                        .and("cpf", client.getCpf())
                        .and("address.street", client.getAddress().getStreet())
                        .and("address.city", client.getAddress().getCity())
                        .and("address.state", client.getAddress().getState())
                        .and("address.zipCode", client.getAddress().getZipCode())
                        .and("address.district", client.getAddress().getDistrict())
                        .and("phone.number", client.getPhone().getNumber())
                        .and("phone.type", client.getPhone().getType())
                        .and("phone.country", client.getPhone().getCountry())
                        .and("phone.areaCode", client.getPhone().getAreaCode())
                        .and("email", client.getEmail())
                        .and("gender", client.getGender())
                        .and("id", client.getId()));
    }
}