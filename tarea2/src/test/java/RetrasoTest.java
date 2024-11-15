import Logica.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.Instant;

public class RetrasoTest {

    @Test
    public void testCalculoDuracionRetraso() {
        Instant horaInicio = Instant.parse("2024-06-10T08:30:00.00Z");
        Instant horaLlegada = Instant.parse("2024-06-10T08:40:00.00Z");
        Empleado empleado = new Empleado("008", "Martinez", "Carlos", "carlos.martinez@example.com");

        Retraso retraso = new Retraso(empleado, horaLlegada, horaInicio);
        Duration duracionEsperada = Duration.between(horaInicio, horaLlegada);

        assertEquals(duracionEsperada, retraso.getTiempoRetraso());
    }

    @Test
    public void testToString() {
        Instant horaInicio = Instant.parse("2024-06-10T08:30:00.00Z");
        Instant horaLlegada = Instant.parse("2024-06-10T08:40:00.00Z");
        Empleado empleado = new Empleado("008", "Martinez", "Carlos", "carlos.martinez@example.com");

        Retraso retraso = new Retraso(empleado, horaLlegada, horaInicio);
        String expectedString = "Retraso{duracionRetraso=PT10M}";

        assertEquals(expectedString, retraso.toString());
    }
}
