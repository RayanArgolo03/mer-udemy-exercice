package services;

import domain.invoice.Order;
import domain.invoice.Product;

import java.util.List;

public class OrderService {
    public OrderService() {
    }

    public Order createOrder() {

        System.out.println("Choice your product: ");
        List<Product> products = MockService.getMockProducts();

        products.forEach(System.out::println);

        System.out.println("Your product: ");
        int choiceProduct = ReadService.readInt();

        while (!ValidUtilService.validChoice(choiceProduct, products.size())) {
            System.out.println("Invalid!");
            products.forEach(System.out::println);
            System.out.println("Your product: ");
            choiceProduct = ReadService.readInt();
        }

        Product product = products.get(choiceProduct - 1);

        System.out.print("Enter quantity of " + product.getName() + ":");
        int quantity = ReadService.readInt();

        while (!validQuantity(quantity)) {
            System.out.println("Invalid!");
            System.out.print("Enter quantity of " + product.getName() + ":");
            quantity = ReadService.readInt();
        }

        return new Order(quantity, product);
    }

    private boolean validQuantity(int quantity) {
        return quantity > 0;
    }

}
