package controllers;

import domain.client.Client;
import domain.invoice.Invoice;
import domain.invoice.Order;
import services.InvoiceService;

import java.util.Set;

public class InvoiceController {

    private InvoiceService invoiceService;

    public InvoiceController() {
        this.invoiceService = new InvoiceService();
    }

    public Invoice create (Client client, Set<Order> orders){
        return invoiceService.generateInvoice(client, orders);
    }

}
