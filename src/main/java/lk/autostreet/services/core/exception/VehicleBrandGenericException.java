package lk.autostreet.services.core.exception;

public class VehicleBrandGenericException extends Exception {

    public VehicleBrandGenericException() {
        super();
    }

    public VehicleBrandGenericException(String message) {
        super(message);
    }

    public VehicleBrandGenericException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleBrandGenericException(Throwable cause) {
        super(cause);
    }

    protected VehicleBrandGenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
