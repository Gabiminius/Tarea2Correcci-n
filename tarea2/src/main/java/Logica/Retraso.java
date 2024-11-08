package Logica;
import java.time.Duration;
import java.time.Instant;
/**
 * La clase Retraso extiende la clase Asistencia para representar el retraso de un empleado
 * en su llegada a una reunión o evento.
 */
public class Retraso extends Asistencia{
    private Duration tiempoRetraso;
    /**
     * Constructor que inicializa un retraso con el empleado, la hora de llegada
     * y la hora de inicio. Calcula el tiempo de retraso en base a estas horas.
     *
     * @param empleado El empleado que llegó tarde.
     * @param horaLlegada La hora en que el empleado llegó.
     * @param horaInicio La hora de inicio de la reunión o evento.
     */
    public Retraso(Empleado empleado, Instant horaLlegada, Instant horaInicio){
        super(empleado, true, horaLlegada);
        this.tiempoRetraso = Duration.between(horaInicio, horaLlegada);
    }
    //getter
    public Duration getTiempoRetraso(){
        return tiempoRetraso;
    }
    //setter
    public void setTiempoRetraso(Duration tiempoRetraso){
        this.tiempoRetraso=tiempoRetraso;
    }
    /**
     * Devuelve una representación en cadena del retraso.
     *
     * @return Una cadena que incluye la duración del retraso.
     */
    public String toString(){
        return "Retraso{" + "duracionRetraso=" + tiempoRetraso + '}';

    }
}


