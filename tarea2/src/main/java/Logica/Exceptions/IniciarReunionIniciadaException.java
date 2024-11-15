package Exceptions;

public class IniciarReunionenIniciadaException extends Exception {
    /**
     * En caso de que se utilice {@code iniciar()} de Reunión cuando exista
     * una reunión que ya ha comenzado o se intente utilizar el método más de una vez.
     * @param message Mensaje que se mostrará en la excepción.
     */
    public IniciarReunionenIniciadaException(String message) {
        super(message);
    }
}