package fr.eseo.e3.poo.projet.blox.modele.pieces;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class IPieceTest {

	
    @Test
    public void testGetElements() {
    	 Coordonnees coord = new Coordonnees(2, 3);
         Couleur couleur = Couleur.values()[0];
         IPiece iPiece = new IPiece(coord, couleur);
        assertEquals(4, iPiece.getElements().size());
    }

    @Test
    public void testToString() {
    	 Coordonnees coord = new Coordonnees(2,3);
         Couleur couleur = Couleur.JAUNE;
         IPiece iPiece = new IPiece(coord,couleur);
        String expected = "IPiece :"+"\n"+
        				  "\t(2, 3) - JAUNE\n" +
                          "\t(2, 2) - JAUNE\n" +
                          "\t(2, 1) - JAUNE\n" +
                          "\t(2, 4) - JAUNE\n";
        assertEquals(expected, iPiece.toString());
    }
}
