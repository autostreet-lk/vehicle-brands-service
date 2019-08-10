package lk.autostreet.services.core.exception;

public class NotUpdatedException extends AppGenericException {

    public NotUpdatedException() {
    }

    public NotUpdatedException(String message) {
        super(message);
    }

    public NotUpdatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUpdatedException(Throwable cause) {
        super(cause);
    }

    public NotUpdatedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
