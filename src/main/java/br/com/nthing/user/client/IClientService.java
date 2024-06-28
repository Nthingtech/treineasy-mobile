package br.com.nthing.user.client;

import java.util.List;

public interface IClientService {

    Client createNewClient(Client cli);
    void updateClient(Client client);
    void deleteClient(Long id);
    Client findById(Long id);
    List<Client> listAll();
    List<Client> searchByKeywordClient(String key);
    List<Client> searchByBirthday(String key);


}
