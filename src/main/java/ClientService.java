import DTO.Client;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                .prepareStatement("INSERT INTO client(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
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

    public long create(String name) throws SQLException {

        try {
            long Id = 0;
            createSt.setString(1, name);
            createSt.executeUpdate();

            ResultSet generatedKeys = createSt.getGeneratedKeys();
            if (generatedKeys.next()) {
                Id = generatedKeys.getLong(1);
            }
            generatedKeys.close();
            return Id;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public String getById(long id) {
        String name = "";

        try {
            getByIdSt.setLong(1, id);
            ResultSet rs = getByIdSt.executeQuery();

            if (rs.next()) {
                name = rs.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    public void deleteById(long id){
        try {
            deleteByIdSt.setLong(1, id);
            int rowsAffected = deleteByIdSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> listAll() {
        List<Client> allClient = new ArrayList<Client>();

        try {
            ResultSet rs = listAllSt.executeQuery();

            while(rs.next()) {

                Client c = new Client(rs.getString("ID"),
                        rs.getString("name"));
                allClient.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allClient;
    }

}
