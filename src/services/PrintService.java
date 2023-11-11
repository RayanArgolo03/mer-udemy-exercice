package services;

import enums.Search;

import java.util.*;

public final class PrintService {

    private PrintService() {
    }

    public static <T> void print(T[] elements) {
        List<T> aux = Arrays.stream(elements).toList();
        for (T element : aux) {
            System.out.println((aux.indexOf(element) + 1) + " - " + element);
        }
    }

    public static void print(Search search) {
        System.out.print("Enter a " + search + ":");
    }

}
