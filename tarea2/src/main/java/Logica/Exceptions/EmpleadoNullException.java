package Exceptions;

/**
 * Si el empleado no es válido, se tendrá esta excepción.
 */
public class EmpleadoNullException extends Exception{
    /**
     * @param message es el mensaje que mostrará esta excepción
     */
    public EmpleadoNullException(String message) {
        super(message);
    }
}