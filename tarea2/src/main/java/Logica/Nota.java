/**
 * La clase Nota representa una nota que contiene un contenido específico.
 */
public class Nota {
    private String contenido;
    /**
     * Constructor que inicializa la nota con el contenido proporcionado.
     *
     * @param contenido El contenido de la nota.
     */
    public Nota(String contenido){
        this.contenido=contenido;

    }
    //getter
    public String getNota(){
        return contenido;
    }
    //setter
    public void setNota(String contenido){
        this.contenido=contenido;
    }
    /**
     * Devuelve una representación en cadena de la nota.
     *
     * @return Una cadena que incluye el contenido de la nota.
     */
    public String toString(){
        return "Nota{'" + contenido + '\'' + '}';

    }
}
