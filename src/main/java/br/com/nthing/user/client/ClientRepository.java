package br.com.nthing.user.client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

    public List<Client> findByFirstOrLast(String fullName) {
        return list("lower(name.firstName) like lower(?1) or lower(name.lastName) like lower(?1)", "%" + fullName + "%");
    }

    /*public int updateClient(Client client) {
        return update("UPDATE Client c SET c.instagram = :instagram, c.name.firstName = :name.firstName, c.name.lastName = :name.lastName, c.birthday = :birthday, c.cpf = :cpf, c.address.street = :address.street, c.address.city = :address.city, c.address.state = :address.state, c.address.zipCode = :address.zipCode, c.address.district = :address.district, c.phone.number = :phone.number, c.phone.type = :phone.type, c.phone.country = :phone.country, c.phone.areaCode = :phone.areaCode, c.email = :email, c.gender = :gender WHERE c.id = :id",
                Parameters.with("instagram", client.getInstagram())
                        .and("name.firstName", client.getName().getFirstName())
                        .and("name.lastName", client.getName().getLastName())
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
    }*/

    public int updateClient(Client client) {
        Client existingClient = find("id", client.getId()).firstResult();
        if (existingClient != null) {
            existingClient.setInstagram(client.getInstagram());
            existingClient.getName().setFirstName(client.getName().getFirstName());
            existingClient.getName().setLastName(client.getName().getLastName());
            existingClient.setBirthday(client.getBirthday());
            existingClient.setCpf(client.getCpf());
            existingClient.getAddress().setStreet(client.getAddress().getStreet());
            existingClient.getAddress().setCity(client.getAddress().getCity());
            existingClient.getAddress().setState(client.getAddress().getState());
            existingClient.getAddress().setZipCode(client.getAddress().getZipCode());
            existingClient.getAddress().setDistrict(client.getAddress().getDistrict());
            existingClient.getPhone().setNumber(client.getPhone().getNumber());
            existingClient.getPhone().setType(client.getPhone().getType());
            existingClient.getPhone().setCountry(client.getPhone().getCountry());
            existingClient.getPhone().setAreaCode(client.getPhone().getAreaCode());
            existingClient.setEmail(client.getEmail());
            existingClient.setGender(client.getGender());


            persist(existingClient);
            return 1;
        } else {
            return 0;
        }
    }
}