package Exceptions;

/**
 * Para el caso en que la duración del la reunión sea nula, se tendrá esta clase excepción
 */
public class DuracionNullException extends Exception {
    /**
     * Constructor
     * @param message es el mensaje que se mostrará en la excepción
     */
    public DuracionNullException(String message) {
        super(message);
    }
}