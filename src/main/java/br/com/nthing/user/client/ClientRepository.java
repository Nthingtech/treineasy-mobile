package br.com.nthing.user.client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import java.util.List;

public class ClientRepository implements PanacheRepository<Client> {

    public List<Client> findByFirstAndLast(String firstName, String lastName) {
        return list("lower(name.firstName =?1) like lower(?1) and lower(name.lastName =?2) like lower(?2)", firstName, lastName);
    }

    public List<Client> findByFirstOrLast(String fullName) {
        return list("lower(name.firstName) like lower(?1) or lower(name.lastName) like lower(?1)", fullName);
    }
}
//todo