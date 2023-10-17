package fr.eseo.e3.poo.projet.blox.modele.pieces;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;

public class OPieceTest {

	
    @Test
    public void testGetElements() {
    	 Coordonnees coord = new Coordonnees(2, 3);
         Couleur couleur = Couleur.values()[0];
         OPiece oPiece = new OPiece(coord, couleur);
        assertEquals(4, oPiece.getElements().size());
    }

    @Test
    public void testToString() {
    	 Coordonnees coord = new Coordonnees(2,3);
         Couleur couleur = Couleur.JAUNE;
         OPiece oPiece = new OPiece(coord,couleur);
        String expected = "OPiece :"+"\n"+
        				  "\t(2, 3) - JAUNE\n" +
                          "\t(3, 3) - JAUNE\n" +
                          "\t(2, 2) - JAUNE\n" +
                          "\t(3, 2) - JAUNE\n";
        assertEquals(expected, oPiece.toString());
    }
}
