package controllers;

import domain.invoice.Order;
import enums.Search;
import exceptions.OrderException;
import repository.OrderRepository;
import services.*;

import java.util.*;

public class OrderController {

    private final Set<Order> orders;
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    public OrderController() {
        this.orderService = new OrderService();
        this.orders = new HashSet<>();

        this.orderRepository = new OrderRepository();

        //SETTING COPY LIST FOR REPO
        orderRepository.setCopyOrders(Collections.unmodifiableSet(orders));
    }


    public OrderService getOrderService() {
        return orderService;
    }

    public Set<Order> getOrders() {
        return Collections.unmodifiableSet(orders);
    }

    public void create() {
        Order order = new Order(19, MockService.getMockProducts().get(1));
        boolean sucess = addOrder(order);
        if (!sucess) throw new OrderException("Order already exists!");
    }

    private boolean addOrder(Order order) {
        return orders.add(order);
    }

    public Optional<Order> find(Search search) {
        PrintService.print(search);

        Optional<Order> order = switch (search) {
            case ID -> orderRepository.findById(ReadService.readInt());
            case NAME -> orderRepository.findByName(ReadService.readName());
            case QUANTITY -> orderRepository.findByQuantity(ReadService.readInt());
            case COST -> orderRepository.findByCost(ReadService.readBigDecimal());
        };

        return Optional.ofNullable(order).orElseThrow(() -> new OrderException("Order does not exist!"));
    }
}
