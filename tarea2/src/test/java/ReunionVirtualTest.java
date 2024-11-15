import Logica.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReunionVirtualTest {

    private ReunionVirtual reunionVirtual;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Empleado organizador;
    private String enlace;

    @BeforeEach
    void setUp() {
        // Datos modificados
        fecha = new Date(); // Manteniendo la fecha actual
        horaPrevista = Instant.now().plus(Duration.ofHours(2)); // Cambiando la hora prevista a 2 horas en el futuro
        duracionPrevista = Duration.ofMinutes(90); // Cambiando la duración prevista a 90 minutos
        organizador = new Empleado("123", "Pérez", "Ana", "ana.perez@example.com"); // Cambié el ID y nombre del organizador
        enlace = "https://zoom.example.com/join/98765"; // Cambié el enlace
        reunionVirtual = new ReunionVirtual(fecha, horaPrevista, duracionPrevista, organizador, TipoReunion.TECNICA, enlace); // Cambié el tipo de reunión
    }

    @Test
    void testConstructor() {
        assertEquals(fecha, reunionVirtual.getFecha());
        assertEquals(horaPrevista, reunionVirtual.getHoraPrevista());
        assertEquals(duracionPrevista, reunionVirtual.getDuracionPrevista());
        assertEquals(organizador, reunionVirtual.getOrganizador());
        assertEquals(TipoReunion.TECNICA, reunionVirtual.getTipoReunion()); // Cambié el tipo de reunión
        assertEquals(enlace, reunionVirtual.getEnlace());
    }

    @Test
    void testSetEnlace() {
        String nuevoEnlace = "https://zoom.example.com/join/54321"; // Cambié el nuevo enlace
        reunionVirtual.setEnlace(nuevoEnlace);
        assertEquals(nuevoEnlace, reunionVirtual.getEnlace());
    }
}
