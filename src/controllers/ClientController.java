package controllers;

import domain.client.Client;
import services.ClientService;

public class ClientController {

    private final ClientService clientService;

    public ClientController() {
        this.clientService = new ClientService();
    }

    public Client create() {
        return clientService.createClient();
    }

    public Client remove(){
        return  clientService.removeClient();
    }
}
