package Logica;
import java.time.Instant;
/**
 * La clase Asistencia representa el registro de asistencia de un empleado.
 * Incluye información sobre el empleado, si asistió o no, y la hora de llegada.
 */

public class Asistencia {

    private Empleado empleado;
    private boolean asistio;
    private Instant horaLlegada;
    /**
     * Constructor que inicializa una instancia de Asistencia.
     *
     * @param empleado El empleado al que se refiere la asistencia.
     * @param asistio Indica si el empleado asistió o no.
     * @param horaLlegada La hora de llegada del empleado.
     */

    public Asistencia(Empleado empleado, boolean asistio,Instant horaLlegada){
        this.empleado= empleado;
        this.asistio= asistio;
        this.horaLlegada=horaLlegada;
    }
    /**
     * Devuelve si el empleado asistió.
     *
     * @return true si el empleado asistió, false en caso contrario.
     */
    public boolean asistio() {
        return asistio;
    }
    //Getters
    public Empleado getEmpleado(){
        return empleado;
    }
    public boolean getAsistio() {
        return asistio;
    }
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
    //Setters
    public void setEmpleado(Empleado empleado){
        this.empleado=empleado;
    }
    public void setAsistio(boolean asistio){
        this.asistio=asistio;
    }
    public void setHoraLlegada(Instant horaLlegada){
        this.horaLlegada=horaLlegada;
    }
    /**
     * Devuelve una representación en cadena de la asistencia.
     *
     * @return Una cadena de texto que incluye el empleado, la hora de llegada y si asistió.
     */
    public String toString(){
        return "Asistencia{" + "empleado=" + empleado + ", horaLlegada=" + horaLlegada + ", asistio=" + asistio + '}';

    }
        }


