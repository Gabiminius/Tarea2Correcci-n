package Exceptions;

/**
 * Para cuando se desborde enum, existirá una excepción
 */
public class OverflowEnumException extends Exception{
    /**
     * Constructor de overflowEnumException
     * @param message es el mensaje que se imprimirá cuando ocurra la excepción.
     */
    public OverflowEnumException(String message){
        super(message);
    }
}
