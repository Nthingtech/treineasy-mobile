package br.com.nthing.user.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    private ClientRepository clientRepository;

    @Inject
    ClientMapper clientMapper;

    public Client createNewClient(Client cli) {

        if (cli.getName() == null || cli.getName().getFirstName().isEmpty() || cli.getName().getLastName().isEmpty()) {
            return null;
        }
        clientRepository.persist(cli);

        return cli;
    }

    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client findById(Long id) {
        return clientRepository.findById(id);
    }

    public List<Client> listAll() {
        return clientRepository.listAll();
    }

    public List<Client> searchByKeywordClient(String key) {
        return clientRepository.findByFirstOrLast(key); //todo test method first or lastname
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = this.clientMapper.toEntity(clientDTO);
        clientRepository.persist(client);
        return this.clientMapper.toDto(client);
    }


    public List<Client> searchByBirthday(String key) {
        return List.of();
    }
}
