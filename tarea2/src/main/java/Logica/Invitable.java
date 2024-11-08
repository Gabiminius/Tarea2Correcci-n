
/**
 * La interfaz Invitable define el comportamiento de objetos que pueden ser invitados a una reunión.
 * Cualquier clase que implemente esta interfaz debe proporcionar una implementación del método invitar.
 */
public interface Invitable {
    /**
     * Invita al objeto a una reunión específica.
     *
     * @param reunion La reunión a la que se invita al objeto.
     */
    public void invitar(Reunion reunion);




}
