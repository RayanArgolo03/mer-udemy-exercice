package domain.invoice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Order {
    private static Long increment = 1L;
    private Long id;
    private int quantity;
    private Product product;
    private LocalDateTime createDate;

    public Order(int quantity, Product product) {
        this.id = increment++;
        this.quantity = quantity;
        this.product = product;
        createDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return quantity == order.quantity && Objects.equals(product, order.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, product);
    }

    @Override
    public String toString() {
        return id + ", " + product + ", " + quantity + " units - Create in " +
                createDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
