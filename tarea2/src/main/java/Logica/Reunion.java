package Logica;
import Exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio=null;
    private Instant horaFin=null;
    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;
    private List<Empleado> listaInvitados;
    private List<Nota> notas;
    private Empleado organizador;
    private TipoReunion tipoReunion;
    private List<Invitable> participantes;
    private List<TipoReunion> tipos;
    private List<Retraso> retrasos;
    /**
     * Constructor para crear una reunión.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista para iniciar la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param organizador Empleado que organiza la reunión.
     * @param tipoReunion Tipo de la reunión.
     */


    public Reunion(Date fecha,Instant horaPrevista,Duration duracionPrevista,Empleado organizador, TipoReunion tipoReunion) throws EmpleadoNullException, MensajeNullException, DuracionNullException, IniciarReunionIniciadaException, FinalizarReunionNoIniciadaException, OverflowEnumException, EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        if((tipoReunion != TipoReunion.OTRO) || (tipoReunion != TipoReunion.MARKETING) || (tipoReunion != TipoReunion.TECNICA)){
            throw new OverflowEnumException("El tipo de reunión no es válido.");
        }else{
            this.tipoReunion=tipoReunion;
            tipos = Arrays.asList(TipoReunion.values());

        }
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;

        this.asistencias = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.participantes = new ArrayList<>();

    }
    /**
     * Obtiene la lista de asistencias registradas en la reunión.
     *
     * @return Lista de asistencias.
     */
    public List<Asistencia> obtenerAsistencias() {
        return asistencias;
    }
    /**
     * Obtiene la lista de ausencias registradas en la reunión.
     *
     * @return Lista de ausencias.
     */
    public List<Asistencia> obtenerAusencias(){
        List<Asistencia> ausencias = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (!asistencia.getAsistio()) {
                ausencias.add(asistencia);
            }
        }
        return ausencias;

    }
    /**
     * Obtiene la lista de retrasos registrados en la reunión.
     *
     * @return Lista de retrasos.
     */
    public List<Retraso> obtenerRetrasos(){
        List<Retraso> retrasos = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia instanceof Retraso) {
                retrasos.add((Retraso) asistencia);
            }
        }
        return retrasos;
    }
    /**
     * Obtiene el total de asistencias registradas.
     *
     * @return Total de asistencias.
     */
    public int obtenerTotalAsistencia(){
        int total = 0;
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getAsistio()) {
                total++;
            }
        }
        return total;

    }
    /**
     * Calcula el porcentaje de asistencia a la reunión.
     *
     * @return Porcentaje de asistencia.
     */
    public float obtenerPorcentajeAsistencia(){
        int totalAsistencia = obtenerTotalAsistencia();
        int totalInvitados = participantes.size(); // Suponiendo que participantes incluye a todos los invitados
        if (totalInvitados == 0) {
            return 0;
        }
        return (totalAsistencia / (float) totalInvitados) * 100;

    }
    /**
     * Calcula el tiempo real de la reunión entre la hora de inicio y la hora de fin.
     *
     * @return Duración real de la reunión.
     */
    public Duration calcularTiempoReal() throws DuracionNullException {
        if(horaInicio == null || horaFin == null){
            throw new DuracionNullException("La reunión debe iniciar y finalizar primero. ");
        }else {
            duracionPrevista = Duration.between(horaInicio, horaFin);
            return duracionPrevista;
        }
    }
    /**
     * Inicia la reunión registrando la hora de inicio.
     */
    public void iniciar() throws IniciarReunionIniciadaException {
        if(this.horaInicio != null){
            throw new IniciarReunionIniciadaException("La reunión ya ha sido iniciada.");
        }else{
            this.horaInicio = Instant.now();
        }
    }
    /**
     * Finaliza la reunión registrando la hora de fin.
     */
    public void finalizar() throws FinalizarReunionNoIniciadaException {
        if(horaInicio == null) {
            throw new FinalizarReunionNoIniciadaException("La reunión no ha sido iniciada.");
        }
        else{
            horaFin = Instant.now();
        }
    }
    /**
     * Agrega un participante a la reunión y envía una invitación.
     *
     * @param participante El participante a agregar.
     */
    public void agregarParticipante(Empleado participante) throws ReunionYaFinalizoException, EmpleadoNoInvitadoException {
        if(!listaInvitados.contains(participante)){
            throw new EmpleadoNoInvitadoException("El empleado no ha sido invitado a la reunión.");
        } else if (horaFin != null) {
            throw new ReunionYaFinalizoException("La reunión ya finalizó.");
        } else {
            Asistencia asistio;
            if (horaInicio == null) {
                asistio = new Asistencia(participante,true,horaInicio);
                asistencias.add(asistio);
            } else {
                asistio = new Retraso(participante,horaPrevista, horaInicio);
                asistencias.add(asistio);
                retrasos.add((Retraso) asistio);
            }
        }
    }
    /**
     * Agrega una nota a la reunión.
     *
     * @param contenido Contenido de la nota.
     */
    public void agregarNota(String contenido) throws MensajeNullException {
        if (contenido == null) {
            throw new MensajeNullException("El mensaje no puede ser nulo");
        } else {
            Nota nota = new Nota(contenido);
            this.notas.add(nota);
        }
    }
    /**
     * Lista las notas de la reunión .
     */
    public void listarNotas() {
        System.out.println("Notas de la reunión:");
        for (Nota nota : notas) {
            System.out.println(nota.getNota());
        }
    }
    //getters

    public Empleado getOrganizador() {
        return organizador;
    }

    public Date getFecha() {
        return fecha;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public TipoReunion getTipoReunion() {
        return tipoReunion;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public List<Invitable> getParticipantes() {
        return participantes;
    }

    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    //setters
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public void setTipoReunion(TipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public void setParticipantes(List<Invitable> participantes) {
        this.participantes = participantes;
    }
    /**
     * Devuelve una representación en cadena de la reunión.
     *
     * @return Una cadena que incluye la información de la reunión.
     */
    public String toString(){
        return "Reunion{" + "fecha=" + fecha + ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin +
                ", asistencias=" + asistencias + ", invitaciones=" + invitaciones + ", notas=" + notas +
                ", organizador=" + organizador + ", tipoReunion=" + tipoReunion + ", participantes=" + participantes + '}';

    }
}