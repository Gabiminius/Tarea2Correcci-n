package Exceptions;

/**
 * En caso de que un empleado no invitado quiera entrar a una reunión.
 */
public class EmpleadoNoInvitadoException extends Exception{
    /**
     * Constructor
     * @param message Mensaje que se mostrará en la excepción.
     */
    public EmpleadoNoInvitadoException(String message) {
        super(message);
    }
}