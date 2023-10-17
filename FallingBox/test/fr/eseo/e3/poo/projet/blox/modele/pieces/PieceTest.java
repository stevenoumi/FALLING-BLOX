package fr.eseo.e3.poo.projet.blox.modele.pieces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class PieceTest {

    private Piece piece;

    @Before
    public void setUp() {
        piece = new IPiece(new Coordonnees(0, 0), Couleur.JAUNE) {
            @Override
            protected void setElements(Coordonnees cord, Couleur coul) {
                Element element = new Element(cord, coul);
                getElements().add(element);
            }
        };
    }

    @Test
    public void testGetElements() {
        assertEquals(4, piece.getElements().size());
    }

    @Test
    public void testSetPosition() throws BloxException {
        piece.setPosition(1, 1);
        assertEquals(new Coordonnees(1, 1), piece.getElements().get(0).getCoordonnees());
    }

    @Test
    public void testSetPuits() {
        Puits puits = new Puits(10, 20);
        piece.setPuits(puits);
        assertEquals(puits, piece.getPuits());
    }

    @Test
    public void testDeplacerDe() throws BloxException {
        piece.setPosition(5, 5);
        piece.setPuits(new Puits(10, 20));
        piece.deplacerDe(0, 1);
        assertEquals(new Coordonnees(5, 6), piece.getElements().get(0).getCoordonnees());
        try {
            piece.deplacerDe(0, 2);
            fail("devrait lancer une exception");
        } catch (IllegalArgumentException e) {
            assertEquals("le deplacement ne peut s'effectuer ", e.getMessage());
        }
        try {
            piece.deplacerDe(2, 0);
            fail("devrait lancer une exception");
        } catch (BloxException e) {
            assertEquals("La pièce sort du puits", e.getMessage());
            assertEquals(BloxException.BLOX_COLLISION, e.getType());
        }
        try {
            piece.deplacerDe(-1, 0);
            fail("devrait lancer une exception");
        } catch (BloxException e) {
            assertEquals("La pièce sort du puits", e.getMessage());
            assertEquals(BloxException.BLOX_SORTIE_PUITS, e.getType());
        }
        try {
            piece.deplacerDe(0, -1);
            fail("devrait lancer une exception");
        } catch (BloxException e) {
            assertEquals("Collision de pièces", e.getMessage());
            assertEquals(BloxException.BLOX_COLLISION, e.getType());
        }
    }
    @Test
    public void testTourner() throws BloxException {
        piece.setPosition(5, 5);
        piece.setPuits(new Puits(10, 20));
        piece.tourner(true);
        assertEquals(new Coordonnees(6, 5), piece.getElements().get(0).getCoordonnees());
        piece.tourner(false);
        assertEquals(new Coordonnees(5, 5), piece.getElements().get(0).getCoordonnees());
        piece.setPosition(9, 19);
        piece.tourner(true);
        assertEquals(new Coordonnees(8, 19), piece.getElements().get(0).getCoordonnees());
        try {
            piece.setPosition(10, 20);
            piece.tourner(true);
            fail("devrait lancer une exception");
        } catch (BloxException e) {
            assertEquals("La pièce sort du puits", e.getMessage());
            assertEquals(BloxException.BLOX_SORTIE_PUITS, e.getType());
        }
    }
    @Test
    public void testToString() {
        String expected = "Piece :\n" +
                "\tElement [couleur=JAUNE, coordonnees=(0,0)]\n" +
                "\tElement [couleur=JAUNE, coordonnees=(1,0)]\n" +
                "\tElement [couleur=JAUNE, coordonnees=(1,1)]\n" +
                "\tElement [couleur=JAUNE, coordonnees=(2,1)]\n";
        String actual = piece.toString();
        assertEquals(expected, actual);
    }


}