package repository;

import domain.invoice.Order;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

public class OrderRepository implements Repository<Order> {

    private Set<Order> copyOrders;

    public OrderRepository() {
    }

    public void setCopyOrders(Set<Order> copyOrders) {
        this.copyOrders = copyOrders;
    }

    @Override
    public Optional<Order> findBy(Predicate<Order> predicate) {
        return copyOrders.stream().filter(predicate)
                .findFirst();
    }

    public Optional<Order> findById(long id) {
        return findBy(order -> order.getId() == id);
    }

    public Optional<Order> findByName(String name) {
        return findBy(order -> order.getProduct().getName().contains(name));
    }

    public Optional<Order> findByQuantity(int quantity) {
        return findBy(order -> order.getQuantity() == quantity);
    }

    public Optional<Order> findByCost(BigDecimal cost) {
        return findBy(order -> order.getProduct().getUnitPrice().equals(cost));
    }


}
