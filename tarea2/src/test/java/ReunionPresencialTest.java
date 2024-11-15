import Logica.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReunionPresencialTest {

    private ReunionPresencial reunionPresencial;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Empleado organizador;
    private String sala;

    @BeforeEach
    void setUp() {
        // Datos modificados
        fecha = new Date(); // Fecha actual
        horaPrevista = Instant.now().plus(Duration.ofHours(1)); // Hora prevista 1 hora en el futuro
        duracionPrevista = Duration.ofMinutes(90); // Duración de 90 minutos
        organizador = new Empleado("112", "Gonzalez", "Luis", "luis.gonzalez@example.com");
        sala = "Sala A-301"; // Nombre de sala actualizado
        reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, organizador, TipoReunion.MARKETING, sala);
    }

    @Test
    void testConstructor() {
        assertEquals(fecha, reunionPresencial.getFecha());
        assertEquals(horaPrevista, reunionPresencial.getHoraPrevista());
        assertEquals(duracionPrevista, reunionPresencial.getDuracionPrevista());
        assertEquals(organizador, reunionPresencial.getOrganizador());
        assertEquals(TipoReunion.MARKETING , reunionPresencial.getTipoReunion());
        assertEquals(sala, reunionPresencial.getSala());
    }

    @Test
    void testSetSala() {
        String nuevaSala = "Sala A-404";
        reunionPresencial.setSala(nuevaSala);
        assertEquals(nuevaSala, reunionPresencial.getSala());
    }
}
