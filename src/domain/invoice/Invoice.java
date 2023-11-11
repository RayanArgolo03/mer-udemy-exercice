package domain.invoice;

import domain.client.Client;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class Invoice {
    private LocalDate issueDate;
    private Client client;
    private Set<Order> orders;

    //Desnecessary atributte, for examplification
    private BigDecimal amount;

    private Invoice(LocalDate issueDate, Client client, Set<Order> orders, BigDecimal amount) {
        this.issueDate = issueDate;
        this.client = client;
        this.orders = orders;
        this.amount = amount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Date: ").append(issueDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))).append("\n");
        builder.append("Client: ").append(client).append("\n");

        builder.append("Orders: ").append("\n");
        for (Order order : orders) {
            builder.append(order.getId()).append(" - ").append(order).append("\n");
        }

        builder.append("Total Value: ").append(amount);
        return builder.toString();
    }

    public static final class InvoiceBuilder {
        private LocalDate issueDate;
        private Client client;
        private Set<Order> orders;
        private BigDecimal amount;

        public InvoiceBuilder() {
        }

        public InvoiceBuilder issueDate(LocalDate issueDate) {
            this.issueDate = issueDate;
            return this;
        }

        public InvoiceBuilder client(Client client) {
            this.client = client;
            return this;
        }

        public InvoiceBuilder orders(Set<Order> orders) {
            this.orders = orders;
            return this;
        }

        public InvoiceBuilder amount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public Invoice build() {
            return new Invoice(issueDate, client, orders, amount);
        }
    }
}

