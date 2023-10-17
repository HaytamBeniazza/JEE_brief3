package dao;

import model.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public interface ClientDAO {
    Optional<Client> create(Client client);
    int delete(int code);
    Optional<Client> update(Client client);

    Client findByCode(int code);
    List<Client> findAll();
    List<Client> find(Client client);

    List<Client> findByAttribute(String searchCriteria);
}
