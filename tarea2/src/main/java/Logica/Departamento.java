package Logica;
import Exceptions.EmpleadoNoInvitadoException;
import Exceptions.ReunionYaFinalizoException;

import java.util.ArrayList;
import java.util.List;
/**
 * La clase Departamento representa un departamento que puede contener varios empleados
 * y ser invitado a una reunión. Implementa la interfaz Invitable.
 */
public class Departamento implements Invitable{

    private String nombredepa;
    private List <Empleado> empleados;
    /**
     * Constructor que inicializa el departamento con un nombre.
     *
     * @param nombredepa El nombre del departamento.
     */

    public Departamento(String nombredepa){
        this.nombredepa=nombredepa;
        this.empleados = new ArrayList<>();
    } /**
     * Agrega un empleado al departamento y le asigna el nombre del departamento.
     *
     * @param empleado El empleado a agregar al departamento.
     */
    public void addEmpleado(Empleado empleado){
        empleado.setDepartamento(this.nombredepa);
        empleados.add(empleado);
    }
    /**
     * Obtiene la cantidad de empleados en el departamento.
     *
     * @return El número de empleados en el departamento.
     */
    int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    //Getter y Setter del Nombre del departamentp
    public String getNombreDepa() {
        return nombredepa;
    }
    public void setNombreDepa(String nombredepa) {
        this.nombredepa = nombredepa;
    }

    /**
     * Obtiene la lista de empleados del departamento.
     *
     * @return La lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece la lista de empleados del departamento.
     *
     * @param empleados La lista de empleados a establecer.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    /**
     * Agrega un empleado al departamento y le asigna el nombre del departamento.
     *
     * @param empleado El empleado a agregar al departamento.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleado.setDepartamento(this.nombredepa); // Asigna el departamento al empleado
        empleados.add(empleado); //Se añade el empleado a la lista de empleados del departamento
    }
    /**
     * Invita a todos los empleados del departamento a una reunión.
     *
     * @param reunion La reunión a la que se invita a los empleados del departamento.
     */
    @Override
    public void invitar(Reunion reunion) throws EmpleadoNoInvitadoException, ReunionYaFinalizoException {
        System.out.println("Enviando invitación al departamento " + nombredepa);
        for (Empleado empleado : empleados) {
            reunion.agregarParticipante(empleado);
        }

    }
    /**
     * Devuelve una representación en cadena del departamento.
     *
     * @return Una cadena que incluye el nombre del departamento y la lista de empleados.
     */
    public String toString(){
        return "Departamento{" + "nombre='" + nombredepa + '\'' + ", empleados=" + empleados + '}';


    }

}

