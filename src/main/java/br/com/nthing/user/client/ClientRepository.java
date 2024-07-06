package br.com.nthing.user.client;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ClientRepository implements PanacheRepository<Client> {

    public List<Client> findByFirstOrLast(String fullName) {
        return list("lower(name.firstName) like lower(?1) or lower(name.lastName) like lower(?1)", "%" + fullName + "%");
    }
}