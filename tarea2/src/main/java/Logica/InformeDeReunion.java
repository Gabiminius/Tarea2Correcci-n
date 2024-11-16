package Logica;
import Exceptions.DuracionNullException;

import java.io.FileWriter;
import java.io.IOException;

/**
 * La clase InformeDeReunion se encarga de generar un informe detallado de una reunión,
 * incluyendo su duración, tipo, participantes y notas. El informe se guarda en un archivo.txt
 */
public class InformeDeReunion {

    private Reunion reunion;
    private String archivo;
    /**
     * Constructor que inicializa el informe con una reunión y un archivo donde se guardará el informe.
     *
     * @param reunion La reunión sobre la cual se generará el informe.
     * @param archivo El archivo donde se guardará el informe generado.
     */

    public InformeDeReunion(Reunion reunion, String archivo) {
        this.reunion = reunion;
        this.archivo=archivo;
    }
    /**
     * Genera el informe de la reunión y lo escribe en el archivo especificado.
     * El informe incluye detalles como la fecha, la hora de inicio y fin, duración,
     * tipo de reunión, participantes y notas.
     */

    public void generarInforme() {

        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("Informe de la Reunión\n");
            writer.write("======================\n");
            writer.write("Fecha: " + reunion.getFecha() + "\n");
            writer.write("Hora prevista: " + reunion.getHoraPrevista() + "\n");
            writer.write("Hora de inicio: " + reunion.getHoraInicio() + "\n");
            writer.write("Hora de fin: " + reunion.getHoraFin() + "\n");
            writer.write("Duración total: " + reunion.calcularTiempoReal().toMinutes() + "minutos\n");
            writer.write("Tipo de reunión: " + reunion.getTipoReunion() + "\n");

            if (reunion instanceof ReunionVirtual) {
                writer.write("Enlace de la reunión: " + ((ReunionVirtual) reunion).getEnlace() + "\n");
            } else if (reunion instanceof ReunionPresencial) {
                writer.write("Sala de la reunión: " + ((ReunionPresencial) reunion).getSala() + "\n");
            }

            // Listar los participantes
            writer.write("\nParticipantes:\n");
            for (Invitable participante : reunion.getParticipantes()) {
                if (participante instanceof Empleado) {
                    Empleado empleado = (Empleado) participante;
                    writer.write("- " + empleado.getNombre() + " " + empleado.getApellidos() + "\n");
                } else if (participante instanceof Departamento) {
                    Departamento departamento = (Departamento) participante;
                    writer.write("- Departamento de " + departamento.getNombreDepa() + "\n");
                }
            }

            writer.write("\nNotas de la reunión:\n");
            for (Nota nota : reunion.getNotas()) {
                writer.write("- " + nota.toString() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error al generar el archivo de informe: " + e.getMessage());
        } catch (DuracionNullException e) {
            throw new RuntimeException(e);
        }
    }
}
