package Logica;
import java.time.Instant;
import java.util.Date;
import java.time.Duration;
/**
 * La clase ReunionPresencial representa una reunión que se lleva a cabo de manera presencial en una sala específica.
 */
public class ReunionPresencial extends Reunion {
    private String sala;
    /**
     * Constructor para crear una reunión presencial.
     *
     * @param fecha             La fecha de la reunión.
     * @param horaPrevista      La hora prevista para iniciar la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param organizador       El empleado que organiza la reunión.
     * @param tipoReunion      El tipo de la reunión.
     * @param sala             La sala donde se llevará a cabo la reunión.
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipoReunion,String sala){
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }
    //getter
    public String getSala() {
        return sala;
    }
    //setter
    public void setSala(String sala) {
        this.sala = sala;
    }
    /**
     * Devuelve una representación en cadena de la reunión presencial.
     *
     * @return Una cadena que representa la reunión presencial, incluyendo la sala.
     */
    public String toString(){
        return "ReunionPresencial{" + "sala='" + sala + '\'' + '}';

    }
}
