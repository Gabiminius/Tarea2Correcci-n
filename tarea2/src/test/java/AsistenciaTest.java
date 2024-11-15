import Logica.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class AsistenciaTest {

    @Test
    @DisplayName("Test creación de Asistencia con asistencia")
    public void test1() {
        Empleado empleado = new Empleado("123", "Gabriela", "Escalona", "gescalona@gmail.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, true, horaLlegada);

        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
        assertTrue(asistencia.asistio());
    }

    @Test
    @DisplayName("Test creación de Asistencia sin asistencia")
    public void test2() {
        Empleado empleado = new Empleado("345", "Valentina", "Seron", "vseron@gmail.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, false, horaLlegada);

        assertEquals(empleado, asistencia.getEmpleado());
        assertEquals(horaLlegada, asistencia.getHoraLlegada());
        assertFalse(asistencia.asistio());
    }

    @Test
    @DisplayName("Test setters de Asistencia")
    public void test3() {
        Empleado empleado = new Empleado("123", "Gabriela", "Escalona", "gescalona@gmail.com");
        Instant horaLlegada = Instant.now();
        Asistencia asistencia = new Asistencia(empleado, true, horaLlegada);

        Empleado nuevoEmpleado = new Empleado("345", "Valentina", "Seron", "vseron@gmail.com");
        asistencia.setEmpleado(nuevoEmpleado);
        asistencia.setHoraLlegada(horaLlegada.plusSeconds(3600));
        asistencia.setAsistio(false);

        assertEquals(nuevoEmpleado, asistencia.getEmpleado());
        assertEquals(horaLlegada.plusSeconds(3600), asistencia.getHoraLlegada());
        assertFalse(asistencia.asistio());
    }
}
