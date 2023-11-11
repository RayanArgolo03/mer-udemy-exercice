package services;

import domain.invoice.Product;
import enums.Acronym;

import java.math.BigDecimal;
import java.util.*;

public class MockService {

    public static List<Product> getMockProducts() {

        return Arrays.asList(
                new Product(1L, "Notebook", new BigDecimal("1999.90")),
                new Product(2L, "Smart TV", new BigDecimal("2000.90")),
                new Product(3L, "Iphone", new BigDecimal("3415.90")),
                new Product(4L, "Ipad Sansung", new BigDecimal("899.90"))
        );
    }

    public static Map<Acronym, String> getMockUfsAndStates() {
        return Map.of(
                Acronym.DF, "Brasília",
                Acronym.RJ, "Rio de Janeiro",
                Acronym.SP, "São Paulo",
                Acronym.PE, "Pernambuco"
        );
    }
}
