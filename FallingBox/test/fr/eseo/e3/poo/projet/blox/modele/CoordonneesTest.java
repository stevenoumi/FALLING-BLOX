package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;


public class CoordonneesTest {

    @Test
    public void testGetAbscisse() {
        Coordonnees coordonnees = new Coordonnees(3, 4);
        assertEquals(3, coordonnees.getAbscisse());
    }

    @Test
    public void testGetOrdonnee() {
        Coordonnees coordonnees = new Coordonnees(3, 4);
        assertEquals(4, coordonnees.getOrdonnee());
    }

    @Test
    public void testSetAbscisse() {
        Coordonnees coordonnees = new Coordonnees(3, 4);
        coordonnees.setAbscisse(5);
        assertEquals(5, coordonnees.getAbscisse());
    }

    @Test
    public void testSetOrdonnee() {
        Coordonnees coordonnees = new Coordonnees(3, 4);
        coordonnees.setOrdonnee(5);
        assertEquals(5, coordonnees.getOrdonnee());
    }

    @Test
    public void testToString() {
        Coordonnees coordonnees = new Coordonnees(3, 4);
        assertEquals("(3, 4)", coordonnees.toString());
    }

    @Test
    public void testEquals() {
        Coordonnees coordonnees1 = new Coordonnees(3, 4);
        Coordonnees coordonnees2 = new Coordonnees(3, 4);
        Coordonnees coordonnees3 = new Coordonnees(5, 6);
        assertTrue(coordonnees1.equals(coordonnees2));
        assertFalse(coordonnees1.equals(coordonnees3));
    }

    @Test
    public void testHashCode() {
        Coordonnees coordonnees1 = new Coordonnees(3, 4);
        Coordonnees coordonnees2 = new Coordonnees(3, 4);
        Coordonnees coordonnees3 = new Coordonnees(5, 6);
        assertEquals(coordonnees1.hashCode(), coordonnees2.hashCode());
        assertNotEquals(coordonnees1.hashCode(), coordonnees3.hashCode());
    }
}
