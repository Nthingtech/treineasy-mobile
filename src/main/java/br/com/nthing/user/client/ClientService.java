package br.com.nthing.user.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ClientService {

    @Inject
    private ClientRepository clientRepository;
    @Inject
    ClientMapper clientMapper;


    public void updateClient(ClientDTO clientDTO) {
        Client client = this.clientMapper.toEntity(clientDTO);
        clientRepository.updateClient(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public ClientDTO findById(Long id)  {
        return this.clientMapper.toDto(clientRepository.findById(id));
    }

    public List<ClientDTO> listAll() {
        return this.clientMapper.toDtoList(clientRepository.listAll());
    }

    public List<ClientDTO> searchByKeywordClient(String key) {
        return this.clientMapper.toDtoList(clientRepository.findByFirstOrLast(key));
    }

    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = this.clientMapper.toEntity(clientDTO);
        clientRepository.persist(client);
        return this.clientMapper.toDto(client);
    }

    public List<ClientDTO> searchByBirthday(LocalDate key) {
        return this.clientMapper.toDtoList(clientRepository.listBirthday(key));
    }

}
