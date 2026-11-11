package es.upo.cal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

/**
 * EPD-4 - Problema 1: tests de algunos métodos de la clase java.lang.Integer.
 * Cada test corresponde a un caso de prueba descrito en la wiki (TC-INT-XX).
 */
public class IntegerTest {

    // TC-INT-01: parseInt convierte un texto con un número positivo
    @Test
    public void parseIntConNumeroPositivo() {
        assertEquals(Integer.parseInt("123"), 123);
    }

    // TC-INT-02: parseInt convierte un texto con un número negativo
    @Test
    public void parseIntConNumeroNegativo() {
        assertEquals(Integer.parseInt("-45"), -45);
    }

    // TC-INT-03: parseInt lanza NumberFormatException si el texto no es un número
    @Test(expectedExceptions = NumberFormatException.class)
    public void parseIntConTextoNoNumerico() {
        Integer.parseInt("hola");
    }

    // TC-INT-04: parseInt lanza NumberFormatException si el número no cabe en un int
    @Test(expectedExceptions = NumberFormatException.class)
    public void parseIntFueraDeRango() {
        Integer.parseInt("2147483648"); // MAX_VALUE + 1
    }

    // TC-INT-05: valueOf devuelve un Integer con el valor indicado
    @Test
    public void valueOfDevuelveElValor() {
        assertEquals(Integer.valueOf(7).intValue(), 7);
    }

    // TC-INT-06: compare devuelve negativo, 0 o positivo según el orden
    @Test
    public void compareOrdenaCorrectamente() {
        assertTrue(Integer.compare(3, 5) < 0);
        assertEquals(Integer.compare(5, 5), 0);
        assertTrue(Integer.compare(9, 5) > 0);
    }

    // TC-INT-07: max y min devuelven el mayor y el menor de dos números
    @Test
    public void maxYMin() {
        assertEquals(Integer.max(4, 10), 10);
        assertEquals(Integer.min(4, 10), 4);
    }

    // TC-INT-08: sum suma dos números
    @Test
    public void sumaDosNumeros() {
        assertEquals(Integer.sum(2, 3), 5);
    }

    // TC-INT-09: sumar 1 a MAX_VALUE "da la vuelta" y se convierte en MIN_VALUE (desbordamiento)
    @Test
    public void desbordamientoDeMaxValue() {
        assertEquals(Integer.MAX_VALUE + 1, Integer.MIN_VALUE);
    }

    // TC-INT-10: toBinaryString pasa el número a binario
    @Test
    public void toBinaryString() {
        assertEquals(Integer.toBinaryString(10), "1010");
    }

    // TC-INT-11: equals compara valores y no confunde Integer con Long
    @Test
    public void equalsComparaValor() {
        assertTrue(Integer.valueOf(100).equals(100));
        assertFalse(Integer.valueOf(100).equals(100L));
    }
}
