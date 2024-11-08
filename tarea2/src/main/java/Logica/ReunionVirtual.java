import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;
    /**
     * Constructor para crear una reunión virtual.
     *
     * @param fecha             La fecha de la reunión.
     * @param horaPrevista      La hora prevista para iniciar la reunión.
     * @param duracionPrevista  La duración prevista de la reunión.
     * @param organizador       El empleado que organiza la reunión.
     * @param tipoReunion      El tipo de la reunión.
     * @param enlace            El enlace para acceder a la reunión virtual.
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipoReunion, String enlace){
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.enlace=enlace;
    }
    //getter
    public String getEnlace() {
        return enlace;
    }
    //setter
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    /**
     * Devuelve una representación en cadena de la reunión virtual.
     *
     * @return Una cadena que representa la reunión virtual, incluyendo el enlace.
     */
    public String toString(){
        return "ReunionVirtual{" + "enlace='" + enlace + '\'' + '}';

    }


}
