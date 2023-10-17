package service;

import dao.ClientDAO;
import model.Client;
import org.glassfish.jersey.client.ClientConfig;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private final ClientDAO clientDAO;
    public ClientService(ClientDAO clientDAO){
        this.clientDAO = clientDAO;
    }
    public Optional<Client> addClient(Client client) {
        Optional<Client> optionalClient = clientDAO.create(client);
        if (optionalClient.isPresent()) {
            return optionalClient;
        } else {
            return Optional.empty();
        }
    }

    public Optional<Client> updateClient(Client client){
        Optional<Client> optionalClient = clientDAO.update(client);
        if (optionalClient.isPresent()) {
            return optionalClient;
        } else {
            return Optional.empty();
        }
    }

    public List<Client> getClients() {
        return clientDAO.findAll();
    }

    public List<Client> searchedClient(String search){
        return clientDAO.findByAttribute(search);
    }

    public int deleteClient(int code){
        return clientDAO.delete(code);
    }

    public Client getClientByCode(int code){
        Client client = clientDAO.findByCode(code);
        return client;
    }
}
