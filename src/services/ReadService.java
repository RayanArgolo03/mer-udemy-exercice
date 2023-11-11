package services;

import java.math.BigDecimal;
import java.util.*;

public final class ReadService {

    private final static Scanner sc = new Scanner(System.in);

    private ReadService() {
    }

    public static String readString() {
        return sc.nextLine();
    }

    public static String readName() {
        return sc.next();
    }

    public static int readInt() {
        return sc.nextInt();
    }

    public static long readLong() {
        return sc.nextLong();
    }

    public static BigDecimal readBigDecimal() {
        return new BigDecimal(ReadService.readString());
    }

    public static <T extends Enum<T>> T readEnum(T[] elements) {

        PrintService.print(elements);
        System.out.print("Your choice: ");
        int choice = ReadService.readInt();

        while (!ValidUtilService.validChoice(choice, elements.length)) {
            System.out.println("Invalid!");
            PrintService.print(elements);
            System.out.print("Your choice: ");
            choice = ReadService.readInt();
        }

        return Arrays.stream(elements).toList().get(choice - 1);
    }


}
