package de.bhtb.exception.handling;

/**
 * Customized Exception;
 */
public class NoCoffeeException extends Exception {
    public NoCoffeeException() {
        super();
    }

    public NoCoffeeException(String message) {
        super(message);
    }

    public NoCoffeeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoCoffeeException(Throwable cause) {
        super(cause);
    }
}
