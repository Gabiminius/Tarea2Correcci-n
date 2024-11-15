package Exceptions;

/**
 * Consideramos esta excepcion cuando se quiera ingresar un empleado a una reunión que ya terminó.
 */
public class ReunionYaFinalizoException extends Exception {
    /**
     * Constructor de la clase
     * @param message Mensaje que se mostrará en la excepción.
     */
    public ReunionYaFinalizoException(String message) {
        super(message);
    }
}