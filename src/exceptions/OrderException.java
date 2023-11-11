package exceptions;

import java.io.Serial;

public class OrderException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -5654780941266524046L;

    public OrderException(String message) {
        super(message);
    }
}
