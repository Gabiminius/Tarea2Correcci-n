import java.time.Instant;
/**
 * La clase Invitacion representa una invitación a una reunión, incluyendo
 * el destinatario, la reunión y la hora de envío de la invitación.
 */
public class Invitacion{
    private Instant horaEnvio;
    private Reunion reunion;
    private Invitable destinatario;
    /**
     * Constructor que inicializa una invitación con el destinatario, la reunión y la hora de envío.
     *
     * @param destinatario El destinatario de la invitación.
     * @param reunion La reunión a la que se está invitando.
     * @param horaEnvio La hora en que se envía la invitación.
     */
    public Invitacion(Invitable destinatario, Reunion reunion, Instant horaEnvio){
        this.destinatario = destinatario;
        this.reunion = reunion;
        this.horaEnvio = horaEnvio;

    }
    /**
     * Envía la invitación al destinatario para la reunión especificada.
     */
    public void invitar(){
        destinatario.invitar(reunion);

    }
    /**
     * Obtiene el destinatario de la invitación.
     *
     * @return El destinatario.
     */
    public Invitable getDestinatario() {
        return destinatario;
    }

    /**
     * Establece el destinatario de la invitación.
     *
     * @param destinatario El destinatario a establecer.
     */
    public void setDestinatario(Invitable destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Obtiene la reunión de la invitación.
     *
     * @return La reunión.
     */
    public Reunion getReunion() {
        return reunion;
    }

    /**
     * Establece la reunión de la invitación.
     *
     * @param reunion La reunión a establecer.
     */
    public void setReunion(Reunion reunion) {
        this.reunion = reunion;
    }

    /**
     * Obtiene la hora de envío de la invitación.
     *
     * @return La hora de envío.
     */
    public Instant getHoraEnvio() {
        return horaEnvio;
    }

    /**
     * Establece la hora de envío de la invitación.
     *
     * @param horaEnvio La hora de envío a establecer.
     */
    public void setHoraEnvio(Instant horaEnvio) {
        this.horaEnvio = horaEnvio;
    }
    /**
     * Devuelve una representación en cadena de la invitación.
     *
     * @return Una cadena que incluye el destinatario, la reunión y la hora de envío.
     */
    @Override
    public String toString(){
        return "Invitacion{" + "destinatario=" + destinatario + ", reunion=" + reunion + ", horaEnvio=" + horaEnvio + '}';

    }
}
