package bank.exception;

/**
 * ExistAccountException.
 *
 * @author Maxim Vanny.
 * @version 3.0
 * @since 0.1
 */
public class ExistAccountException extends Exception {
    /**
     * Constructor.
     *
     * @param message message for user
     */
    public ExistAccountException(final String message) {
        super(message);
    }
}
