package lk.autostreet.services.core.exception;

public class NotCreatedException extends AppGenericException {

    public NotCreatedException() {
    }

    public NotCreatedException(String message) {
        super(message);
    }

    public NotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotCreatedException(Throwable cause) {
        super(cause);
    }

    public NotCreatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
