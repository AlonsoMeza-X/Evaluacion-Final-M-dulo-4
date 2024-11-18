package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class PromediosServicioImpTest {

    PromediosServicioImp promedio = new PromediosServicioImp();

    @Test
    @DisplayName("Test Promedio con varias notas")
    void testPromedioNotas() {
        assertEquals(4.5, promedio.calcularPromedio(Arrays.asList(4.0, 5.0, 4.5)));
    }

    @Test
    @DisplayName("Test Promedio con nota 1.0 y 7.0")
    void testPromedioExtremo() {
        assertEquals(7.0, promedio.calcularPromedio(Arrays.asList(7.0, 7.0, 7.0)));
        assertEquals(1.0, promedio.calcularPromedio(Arrays.asList(1.0, 1.0, 1.0)));
    }

    @Test
    @DisplayName("Test Promedio sin notas")
    void testPromedioSin() {
        assertEquals(0, promedio.calcularPromedio(Collections.emptyList()));
    }

}