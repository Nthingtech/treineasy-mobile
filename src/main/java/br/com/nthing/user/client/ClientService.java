package br.com.nthing.user.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClientService implements IClientService {

    @Inject
    private ClientRepository clientRepository;

    @Override
    public Client createNewClient(Client cli) {

        if (cli.getName() == null || cli.getName().getFirstName().isEmpty() || cli.getName().getLastName().isEmpty()) {
            return null;
        }
        clientRepository.persist(cli);

        return cli;
    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> listAll() {
        return clientRepository.listAll();
    }

    @Override
    public List<Client> searchByKeywordClient(String key) {
        return clientRepository.findByFirstOrLast(key); //todo test method first or lastname
    }




    @Override
    public List<Client> searchByBirthday(String key) {
        return List.of();
    }
}
