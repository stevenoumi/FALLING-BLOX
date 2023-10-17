package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ElementTest {

    @Test
    public void testGetCoordonnees() {
        Coordonnees c = new Coordonnees(3, 4);
        Element e = new Element(c);
        assertEquals(c, e.getCoordonnees());
    }

    @Test
    public void testGetCouleur() {
        Element e = new Element(new Coordonnees(1, 2));
        assertEquals(Couleur.values()[0], e.getCouleur());
    }

    @Test
    public void testSetCouleur() {
        Element e = new Element(new Coordonnees(1, 2));
        Couleur c = Couleur.values()[1];
        e.setCouleur(c);
        assertEquals(c, e.getCouleur());
    }

    @Test
    public void testSetCoordonnees() {
        Element e = new Element(new Coordonnees(1, 2));
        Coordonnees c = new Coordonnees(3, 4);
        e.setCoordonnees(c);
        assertEquals(c, e.getCoordonnees());
    }

    @Test
    public void testToString() {
        Element e = new Element(new Coordonnees(1, 2), Couleur.values()[1]);
        assertEquals("(1, 2) - " + Couleur.values()[1], e.toString());
    }

    @Test
    public void testHashCode() {
        Element e1 = new Element(new Coordonnees(1, 2), Couleur.values()[1]);
        Element e2 = new Element(new Coordonnees(1, 2), Couleur.values()[1]);
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    public void testEquals() {
        Element e1 = new Element(new Coordonnees(1, 2), Couleur.values()[1]);
        Element e2 = new Element(new Coordonnees(1, 2), Couleur.values()[1]);
        assertTrue(e1.equals(e2));
    }

    @Test
    public void testDeplacerDe() {
        Element e = new Element(new Coordonnees(1, 2));
        e.deplacerDe(3, 4);
        assertEquals(new Coordonnees(4, 6), e.getCoordonnees());
    }
}
