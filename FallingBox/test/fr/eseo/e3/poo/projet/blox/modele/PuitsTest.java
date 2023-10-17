package fr.eseo.e3.poo.projet.blox.modele;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class PuitsTest {

    private Puits puits;

    @BeforeEach
    void setUp() {
        puits = new Puits();
    }

    @Test
    void testGetPieceActuelle() {
        assertNull(puits.getPieceActuelle());
    }

    @Test
    void testGetPieceSuivante() {
        assertNotNull(puits.getPieceSuivante());
    }

    @Test
    void testSetPieceSuivante() {
        Piece piece = UsineDePiece.genererPiece();
        puits.setPieceSuivante(piece);
        assertSame(piece, puits.getPieceSuivante());
    }

    @Test
    void testGetProfondeur() {
        assertEquals(Puits.PROFONDEUR_PAR_DEFAUT, puits.getProfondeur());
    }

    @Test
    void testSetProfondeur() {
        assertThrows(IllegalArgumentException.class, () -> puits.setProfondeur(10));
    }

    @Test
    void testGetLargeur() {
        assertEquals(Puits.LARGEUR_PAR_DEFAUT, puits.getLargeur());
    }

    @Test
    void testSetLargeur() {
        assertThrows(IllegalArgumentException.class, () -> puits.setLargeur(20));
    }

    @Test
    void testGetTas() {
        assertNotNull(puits.getTas());
    }

    @Test
    void testSetTas() {
        Tas tas = new Tas(puits);
        puits.setTas(tas);
        assertSame(tas, puits.getTas());
    }

    @Test
    void testGravite() {
        puits.setPieceSuivante(UsineDePiece.genererPiece());
        puits.gravite();
        assertNotNull(puits.getPieceActuelle());
    }

    @Test
    void testGererCollision() {
        puits.setPieceSuivante(UsineDePiece.genererPiece());
        for (int i = 0; i < puits.getProfondeur(); i++) {
            puits.gravite();
        }
        assertNull(puits.getPieceActuelle());
        assertNotNull(puits.getPieceSuivante());
    }
    @Test
    public void testHashCode() {
        // Arrange
        Puits puits1 = new Puits();
        Puits puits2 = new Puits();
        
        // Act
        int hashCode1 = puits1.hashCode();
        int hashCode2 = puits2.hashCode();
        
        // Assert
        assertEquals(hashCode1, hashCode2);
    }
    @Test
    public void testEquals() {
        // Arrange
        Puits puits1 = new Puits();
        Puits puits2 = new Puits();
        
        // Act
        boolean equals = puits1.equals(puits2);
        
        // Assert
        assertTrue(equals);
    }
    @Test
    public void testToString() {
        // Arrange
        Puits puits3  = new Puits();
        
        // Act
        String str = puits3.toString();
        
        // Assert
        assertNotNull(str);
    }

    @Test
    public void testAddPropertyChangeListener() {
        // Arrange
        Puits puits2 = new Puits();
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                // do something
            }
        };
        
        // Act
        puits.addPropertyChangeListener(listener);
        
        // Assert
        assertTrue(Arrays.asList(puits2.getPropertyChangeListeners()).contains(listener));
    }
    @Test
    public void testRemovePropertyChangeListener() {
        // Arrange
        Puits puits1 = new Puits();
        PropertyChangeListener listener = new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                // do something
            }
        };
        puits.addPropertyChangeListener(listener);
        
        // Act
        puits.removePropertyChangeListener(listener);
        
        // Assert
        assertFalse(Arrays.asList(puits1.getPropertyChangeListeners()).contains(listener));
    }
    @Test
    public void testSetPieceActuelle() {
        // Arrange
        Piece piece = UsineDePiece.genererPiece();      
        // Act
        puits.setPieceActuelle(piece);    
        // Assert
        assertEquals(piece, puits.getPieceActuelle());
    }





   
    


}
