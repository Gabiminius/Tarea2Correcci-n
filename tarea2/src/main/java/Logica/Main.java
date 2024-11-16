package Logica;

import java.time.*;
import Exceptions.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author : Gabriela Escalona
 * @author : Valentina Serón
 * @version : 1.2
 */

public class Main {
    /**
     * Método principal que ejecuta el programa.
     * @param args son los argumentos de la línea de comandos.
     * @throws EmpleadoNullException Excepción para cuando el empleado es null.
     * @throws MensajeNullException Excepción para cuando el mensaje es null.
     * @throws IniciarReunionIniciadaException Excepción para cuando se intenta iniciar una reunión ya iniciada.
     * @throws FinalizarReunionNoIniciadaException Excepción para cuando se intenta finalizar una reunión que no ha sido iniciada.
     * @throws OverflowEnumException Excepción para cuando el tipo de reunión no es válido.
     * @throws EmpleadoNoInvitadoException Excepción para cuando un empleado no invitado quiera entrar a una reunión.
     * @throws ReunionYaFinalizoException Excepción para cuando se intenta agregar un empleado a una reunión que ya finalizó.
     * @throws DuracionNullException Excepción para cuando la duración de la reunión es null.

     */
    public static void main(String[] args) throws EmpleadoNullException, MensajeNullException, DuracionNullException, IniciarReunionIniciadaException, FinalizarReunionNoIniciadaException, OverflowEnumException, EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        // Crear un objeto Date con año, mes y día
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.NOVEMBER);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        Date fecha = calendar.getTime();
        // Crear un objeto LocalDateTime con hora y minuto
        LocalDateTime hora = LocalDateTime.of(2024, Month.NOVEMBER, 20, 10, 15); // Año, Mes, Día, Hora, Minutos
        // Convertir LocalDateTime a Instant
        Instant horaPrevista = hora.atZone(ZoneId.systemDefault()).toInstant();
        Duration duracionPrevista = Duration.ofHours(1).plusMinutes(30);

        // Crear una lista de empleados los cuales serán invitados a la reunión
        List<Empleado> listaInvitados = new ArrayList<>();
        Empleado empleado1 = new Empleado("1", "Valentina", "Seron", "vseron@udec.cl");
        listaInvitados.add(empleado1);
        Empleado empleado2 = new Empleado("2", "Gabriela", "Escalona", "gescalona@udec.cl");
        listaInvitados.add(empleado2);
        Empleado empleado3 = new Empleado("3", "Barbie", "Donoso", "bdonoso@udec.cl");
        listaInvitados.add(empleado3);
        Empleado empleado4 = new Empleado("4", "Antonio", "Marín", "amarin@udec.cl");
        listaInvitados.add(empleado4);
        Empleado empleado5 = new Empleado("5", "Leila", "Flores", "lflores@udec.cl");
        listaInvitados.add(empleado5);
        //Agregando un empleado nulo a la lista de invitados
        Empleado empleadonulo = null;
        listaInvitados.add(empleadonulo);
        //Creando un empleado no invitado a la reunión
        Empleado noInvitado = new Empleado("6", "Ignacio", "Soto", "isoto@udec.cl");
        //Creando un empleado que llegará al finalizar la reunión
        Empleado superAtrasado = new Empleado("7", "John", "Valenzuela", "jvalenzuela@udec.cl");
        listaInvitados.add(superAtrasado);


        //Intentando finalizar una reunión que no ha sido iniciada
        Reunion reunion = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, empleado4, TipoReunion.TECNICA,"Sala 4");

        try {
            reunion.finalizar();
        }
        catch (FinalizarReunionNoIniciadaException e) {
            System.out.println("No se puede finalizar una reunión que no ha sido iniciada");
        }

        //Calculando tiempo antes de haber finalizado la reunión
        reunion.agregarParticipante(empleado1);
        reunion.iniciar();
        try{
            reunion.calcularTiempoReal();
        }
        catch (DuracionNullException e){
            System.out.println("Error, la reunion no ha sido finalizada o no existe");
        }

        //Iniciando la reunión una segunda vez
        Reunion reunion3 = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, empleado3, TipoReunion.OTRO,"Sala 1");
        reunion3.iniciar();
        try{
            reunion3.iniciar();
        }
        catch (IniciarReunionIniciadaException e){
            System.out.println("No se puede iniciar una reunión que ya empezó");
        }
        try{
            reunion.agregarParticipante(noInvitado);
        }  catch(EmpleadoNoInvitadoException e){
            System.out.println("Error, el/la empleado no tiene invitación para la reunión");
        } catch(ReunionYaFinalizoException e){
            System.out.println("Oh no! La reunión ya ha terminado");
        }

        //Agregando notas a la reunión
        reunion.agregarNota("Nota 1");
        reunion.agregarNota("Nota 2");

        //Empleados atrasados entrando a la reunión
        reunion.agregarParticipante(empleado2);
        reunion.agregarParticipante(empleado3);

        //Creamos una reunion simulada de 60 segundos
        try {
            TimeUnit.SECONDS.sleep(60); // Retraso de 60 segundos
        } catch (InterruptedException e) {
            // Manejar la interrupción
        }

        reunion.finalizar();
        //Entrando un empleado a una reunion ya finalizada.
            try{
                reunion.agregarParticipante(superAtrasado);
            } catch(EmpleadoNoInvitadoException e){
                System.out.println("Error, el empleado no ha sido invitado a esta reunión");
            }
            catch (ReunionYaFinalizoException e){
                System.out.println("Oh no! la reunión ya ha terminado");
            }
        System.out.println();



        //Reunión ya finalizada e imprimimos por terminal todos los métodos que tenga la reunión.

        InformeDeReunion informe = new InformeDeReunion(reunion,"InformeReunion");
        informe.generarInforme();
        System.out.println();

        System.out.println("Organizador de la reunión: " + reunion.getOrganizador());
        System.out.println();

        //Pasar de tiempo en formato Duration a formato LocalTime
        Duration duracion = reunion.calcularTiempoReal();
        long horas = duracion.toHours();
        long minutos = duracion.toMinutesPart();
        long segundos = duracion.toSecondsPart();
        // Creamos un objeto LocalTime con los componentes obtenidos
        LocalTime tiempo = LocalTime.of((int) horas, (int) minutos, (int) segundos);
        System.out.println("Duración de la reunión: " + tiempo.toString());
        System.out.println();

        System.out.println("Empleados que asistieron a la reunión: ");
        for (Object em : reunion.obtenerAsistencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que llegaron tarde a la reunión: ");
        for (Object em : reunion.obtenerRetrasos())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que no asistieron a la reunión: ");
        for (Object em : reunion.obtenerAusencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Cantidad de empleados que asistieron a la reunión: " + reunion.obtenerTotalAsistencia());
        System.out.println();

        System.out.println("Porcentaje de asistencia a la reunión: " + reunion.obtenerPorcentajeAsistencia()+"%");
        System.out.println();

        System.out.println("Notas de la reunión: " + reunion.getNotas());
        System.out.println();
        System.out.println();



    }
}
