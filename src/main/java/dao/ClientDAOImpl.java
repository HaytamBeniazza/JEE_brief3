package dao;

import Connection.DatabaseConnection;
import model.Client;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientDAOImpl implements ClientDAO{

    private Connection connection;
    Client client = new Client();

    public ClientDAOImpl(){
        connection = DatabaseConnection.getConnection();
    }
    @Override
    public Optional<Client> create(Client client) {
        try{
            if(client == null){
                throw new Exception("The value of employee is null");
            }
            String sql = "insert into clients(firstname, lastname,address, birthdate, phone) values (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setObject(4, client.getBirthDay());
            preparedStatement.setString(5, client.getPhone());
            preparedStatement.setString(3, client.getAddress());
            int affectedRows = preparedStatement.executeUpdate();



            if(affectedRows == 0){
                throw new Exception("Error in insertion");
            }else{
                System.out.println("client added");
                return Optional.of(client);
            }

        }catch (Exception e){
            System.out.println(e.getClass()+":"+e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public int delete(int code) {
        try{
            String sql = "delete from clients where code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, code);
            int result = preparedStatement.executeUpdate();
            preparedStatement.close();
            if (result != 0) {
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Optional<Client> update(Client client) {

        try{
            if(client == null){
                throw new Exception("The value of employee is null");
            }
            String sql = "update clients set firstname = ?, lastname = ?, birthdate = ?, phone = ?, address = ? where code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setObject(3, client.getBirthDay());
            preparedStatement.setString(4, client.getPhone());
            preparedStatement.setString(5, client.getAddress());
            preparedStatement.setInt(6, client.getCode());
            int affectedRows = preparedStatement.executeUpdate();

            if(affectedRows == 0){
                throw new Exception("Error in update");
            }else{
                System.out.println("client updated");
                return Optional.of(client);
            }

        }catch (Exception e){
            System.out.println(e.getClass()+":"+e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public Client findByCode(int code) {
        try {
            String query = "select * from clients where code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, code);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {

                client.setCode(result.getInt("code"));
                client.setFirstName(result.getString("firstname"));
                client.setLastName(result.getString("lastname"));
                client.setBirthDay(result.getDate("birthdate").toLocalDate());
                client.setPhone(result.getString("phone"));
                client.setAddress(result.getString("address"));
            }
            return client;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM clients";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Client addClient = new Client();
                addClient.setCode(result.getInt("code"));
                addClient.setFirstName(result.getString("firstname"));
                addClient.setLastName(result.getString("lastname"));
//                Date sqlDate = result.getDate("birthdate");
//                if (sqlDate != null) {
//                    addClient.setBirthDay(sqlDate.toLocalDate());
//                } else {
//                    System.out.println("error in birth date");
//                }
                addClient.setBirthDay(result.getDate("birthdate").toLocalDate());
                addClient.setPhone(result.getString("phone"));
                addClient.setAddress(result.getString("address"));
                clients.add(addClient);
            }
//            return clients;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public List<Client> find(Client client) {
//        String query = "SELECT * FROM client where code = ?";
//        List<Client> clients = new ArrayList<>();
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(query);
//            preparedStatement.setInt(1, client.getCode());
//            ResultSet result = preparedStatement.executeQuery();
//            while (result.next()) {
//                Client addClient = new Client();
//                addClient.setCode(result.getInt("code"));
//                addClient.setFirstName(result.getString("nom"));
//                addClient.setLastName(result.getString("prenome"));
//                addClient.setBirthDay(result.getDate("birthdate").toLocalDate());
//                addClient.setPhone(result.getString("phone"));
//                addClient.setAddress(result.getString("adresse"));
//                clients.add(addClient);
//            }
//            return clients;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return null;
    }

    @Override
    public List<Client> findByAttribute(String search) {
        List<Client> searchResults = new ArrayList<>();
        try {
            String query = "select * from clients where firstname like ? or lastname like ? or code = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + search + "%");
            preparedStatement.setString(2, "%" + search + "%");
            try {
                int code = Integer.parseInt(search);
                preparedStatement.setInt(3, code);
            } catch (NumberFormatException e) {
                preparedStatement.setInt(3, -1);
            }
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {

                client.setCode(result.getInt("code"));
                System.out.println(client.getCode());
                client.setFirstName(result.getString("firstname"));
                client.setLastName(result.getString("lastname"));
                client.setBirthDay(result.getDate("birthdate").toLocalDate());
                client.setPhone(result.getString("phone"));
                client.setAddress(result.getString("address"));

                searchResults.add(client);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchResults;
    }
}
