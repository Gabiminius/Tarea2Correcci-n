package Logica;

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;
    /**
     * Constructor de la clase Empleado.
     * @param id Identificador del empleado.
     * @param nombre Nombre del empleado.
     * @param apellidos Apellidos del empleado.
     * @param correo Correo del empleado.
     */
    public Empleado(String id,String nombre,String apellidos,String correo){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;

    }
    //getters
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public String getDepartamento() {
        return departamento;
    }
    //Setters
    public void setId(String id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellido) {
        this.apellidos = apellidos;
    }
    public void setCorreo(String correo) {
        this.correo=correo;
    }
    public void setDepartamento(String departamento) {
        this.departamento=departamento;
    }


    /**
     * Envía una invitación a un empleado para una reunión, ajustando el mensaje
     * dependiendo de si es una reunión virtual o presencial.
     *
     * @param reunion La reunión a la que se invita al empleado. Puede ser una reunión virtual o presencial.
     */
    @Override
    public void invitar(Reunion reunion) {
        String mensaje = "Estimado " + nombre + " " + apellidos + ", está invitado a una reunión ";

        if (reunion instanceof ReunionVirtual) {
            mensaje = mensaje + "virtual en el siguiente enlace: " + ((ReunionVirtual) reunion).getEnlace();
        } else if (reunion instanceof ReunionPresencial) {
            mensaje = mensaje + "presencial en la sala: " + ((ReunionPresencial) reunion).getSala();
        }
        System.out.println("Invitación enviada a " + nombre + " via email: " + correo + " con detalles: " + mensaje);
    }
    /**
     * Devuelve una representación en cadena del empleado.
     *
     * @return Una cadena que incluye el id del empleado, sus apellidos, nombre, correo y departamento.
     */
    @Override
    public String toString() {
        return "Empleado [id=" + id + ", apellido=" + apellidos + ", nombre=" + nombre + ", correo=" + correo + ", departamento=" + departamento + "]";
    }

}





