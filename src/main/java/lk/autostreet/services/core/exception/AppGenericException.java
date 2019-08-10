package lk.autostreet.services.core.exception;

public class AppGenericException extends Exception {

    public AppGenericException() {
        super();
    }

    public AppGenericException(String message) {
        super(message);
    }

    public AppGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppGenericException(Throwable cause) {
        super(cause);
    }

    protected AppGenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
