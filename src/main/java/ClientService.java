import DTO.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private java.sql.PreparedStatement createSt;
    private java.sql.PreparedStatement getByIdSt;
    private java.sql.PreparedStatement setNameSt;
    private java.sql.PreparedStatement deleteByIdSt;
    private java.sql.PreparedStatement listAllSt;
    private Database database;
    private Connection connection;

    public ClientService() throws SQLException {
        database = Database.getInstance();
        connection = database.getConnection();

        try {
        createSt =  (java.sql.PreparedStatement)  connection
                .prepareStatement("INSERT INTO client(name) VALUES (?)");
        getByIdSt = (java.sql.PreparedStatement)  connection
                .prepareStatement("SELECT * FROM client WHERE ID = ?");
        setNameSt = (java.sql.PreparedStatement)  connection
                .prepareStatement("UPDATE client SET name = ? WHERE ID = ? ");
        deleteByIdSt = (java.sql.PreparedStatement)  connection
                .prepareStatement("DELETE FROM client WHERE ID = ?");
        listAllSt = (java.sql.PreparedStatement)  connection
                .prepareStatement("SELECT * FROM client");
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }

    public long create(Client client) throws SQLException {

        try {
            long Id = 0;
            createSt.setString(1, client.getName());
            createSt.executeUpdate();
            ResultSet generatedKeys = createSt.getGeneratedKeys();
            if (generatedKeys.next()) {
                Id = generatedKeys.getLong(1);
            }
            generatedKeys.close();
            System.out.println("Successfully added to the client table with id: " + Id );
            return Id;
        } catch (SQLException e) {
            System.out.println("Not added to the client table");
            throw new RuntimeException(e);
        }

    }

    public String getById(long id) {
        String name = "";

        try {
            getByIdSt.setLong(1, id);
            getByIdSt.executeUpdate();
            ResultSet rs = getByIdSt.executeQuery();

            if (rs.next()) {
                name = rs.getString("name");
            }

            System.out.println("Client with ID: " + id +  ": " + name);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Client with ID: " + id +  " not found");
        }
        return name;
    }

    public void deleteById(long id){
        try {
            deleteByIdSt.setLong(1, id);
            int rowsAffected = deleteByIdSt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Successfully deleted client with ID: " + id);
            } else {
                System.out.println("Client with ID: " + id + " not found, no deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Not deleted client with ID: " + id);
        }
    }

    public List<Client> listAll() {

        List<Client> all_Client = new ArrayList<Client>();

        try {

            ResultSet rs = listAllSt.executeQuery();

            while(rs.next()) {

                Client c = new Client(rs.getString("ID"),
                        rs.getString("name"));
                all_Client.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all_Client;
    }

}
