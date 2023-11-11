package services;

import controllers.ClientController;
import controllers.InvoiceController;
import controllers.OrderController;
import domain.client.Client;
import enums.Choice;
import enums.CrudOption;
import enums.Search;

public final class RunService {
    private RunService() {
    }

    public static void runProgram() {

        ClientController clientController = new ClientController();
        OrderController orderController = new OrderController();
        InvoiceController invoiceController = new InvoiceController();
        Client client = null;

        inner:
        while (true) {

            try {
                if (client == null) {
                    System.out.println("New client in program!");
                    client = clientController.create();
                }

                System.out.println("Program actions: ");
                CrudOption crudOption = ReadService.readEnum(CrudOption.values());

                Choice choice;
                switch (crudOption) {
                    case BUY -> {
                        //CREATE ORDER WITH PRODUCT (UNIQUE IN EACH ORDER)
                        do {
                            orderController.create();
                            System.out.println("Do you have any other orders?");
                            choice = ReadService.readEnum(Choice.values());
                        } while (choice == Choice.YES);
                    }

                    case SEARCH -> {
                        do {
                            //SEARCH ORDER IN ORDERS
                            System.out.println("Enter your search choice: ");
                            Search search = ReadService.readEnum(Search.values());

                            orderController.find(search)
                                    .ifPresent(order -> System.out.println("Your order details: " + order));

                            System.out.println("Keep searching?");
                            choice = ReadService.readEnum(Choice.values());

                        } while (choice == Choice.YES);
                    }
                    case STOP -> {
                        System.out.println("Your invoice: ");
                        System.out.println(invoiceController.create(client, orderController.getOrders()));
                        break inner;
                    }
                }

                System.out.println("Create a new customer?");
                choice = ReadService.readEnum(Choice.values());

                if (choice == Choice.YES) {
                    client = clientController.remove();
                } else {
                    System.out.println(client.getName() + " will continue to be used!");
                }

            } catch (Exception e) {
                System.out.println("Error! " + e.getMessage());
                break inner;
            }
        }

    }

}
