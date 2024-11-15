import Logica.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    @Test
    public void testSetAndGetContenido() {
        String contenido = "Este es un contenido de prueba";
        Nota nota = new Nota(contenido);
        assertEquals(contenido, nota.getNota(), "El contenido recuperado debe coincidir con el contenido asignado");

        String nuevoContenido = "Nuevo contenido de prueba";
        nota.setNota(nuevoContenido);
        assertEquals(nuevoContenido, nota.getNota()); //El contenido debería haber sido actualizado
    }

    @Test
    public void testToString() {
        String contenido = "Prueba de contenido para toString";
        Nota nota = new Nota(contenido);
        String expectedToString = "Nota{" + contenido + "}";
        assertEquals(expectedToString, nota.toString()); //El método toString debe devolver el formato correcto
    }
}
