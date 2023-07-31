import DTO.Client;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = null;
        long clientId = 0;
        try {
            clientService = new ClientService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            clientId = clientService.create("Test 1");
            System.out.println("Created client with ID: " + clientId);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        try {
            String clientName = clientService.getById(clientId);
            System.out.println("Client name: " + clientName);

        } catch (Exception e) {
                throw new RuntimeException(e);
        }

        try {
            clientService.deleteById(clientId);
            System.out.println("Client deleted.");

        } catch (Exception e) {
                throw new RuntimeException(e);
        }

        try {
            System.out.println("List all clients:");
            clientService.listAll().forEach(client -> System.out.println("ID: " + client.getID() + ", Name: " + client.getName()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
