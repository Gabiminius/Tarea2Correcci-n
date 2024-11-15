package Exceptions;

/**
 * Si el mensaje es nulo, se tiene esta excepción
 */
public class MensajeNullException extends Exception{
    /**
     * @param mensaje Mensaje que se mostrará en la excepción.
     * Constructor:
     */
    public MensajeNullException(String mensaje){
        super(mensaje);
    }
}
