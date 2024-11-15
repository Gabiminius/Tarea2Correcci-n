package Exceptions;

/**
 * Consideramos esta excepcion uando se utiliza {@code finalizar()} de {@code Reunión}
 * antes de haber utilizado {@code iniciar()}.
 */
public class FinalizarReunionNoIniciadaException extends Exception {
    /**
     * Constructor de la clase
     * @param message Mensaje que se mostrará en la excepción.
     */
    public FinalizarReunionNoIniciadaException(String message) {
        super(message);
        /** el mensaje estará en el main */
    }
}