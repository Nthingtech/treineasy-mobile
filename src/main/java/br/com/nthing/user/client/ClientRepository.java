package br.com.nthing.user.client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

    public List<Client> findByFirstOrLast(String fullName) {
        return list("lower(name.firstName) like lower(?1) or lower(name.lastName) like lower(?1)", "%" + fullName + "%");
    }


    public List<Client> listBirthday(LocalDate birthday) {
        return list("birthday = ?1", birthday) ;
    }

    public void updateClient(Client client) {
        Client existingClient = find("id", client.getId()).firstResult();

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
    }

}