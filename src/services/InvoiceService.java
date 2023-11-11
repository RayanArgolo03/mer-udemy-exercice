package services;

import domain.client.Client;
import domain.invoice.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class InvoiceService {

    public InvoiceService() {
    }

    public Invoice generateInvoice(Client client, Set<Order> orders) {
        return new Invoice.InvoiceBuilder()
                .issueDate(LocalDate.now())
                .client(client)
                .orders(orders)
                .amount(orders.stream()
                        .map(Order::getProduct)
                        .map(Product::getUnitPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .build();
    }
}
