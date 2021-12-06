package users;

import data.Client;
import services.Credit;

import java.util.ArrayList;

public class BankEmployee {
    private long id;
    private long bankId;
    private String name;
    private String surname;
    private static ArrayList<Client> clients = new ArrayList<>();

    public static Credit findCredit(int creditID, Client client) {
        for (Credit temp : client.getCredits()) {
            if (temp.getID() == creditID) {
                return temp;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static Client findClient(int clientID) {
        for (Client client : BankEmployee.getClients()) {
            if (client.getId() == clientID)
                return client;
        }
        return null;
    }

    public static void addClient(Client client) {
        BankEmployee.clients.add(client);
    }
}
