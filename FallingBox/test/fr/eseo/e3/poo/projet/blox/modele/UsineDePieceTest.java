package fr.eseo.e3.poo.projet.blox.modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePieceTest {

    @Test
    public void testGenererPieceAleatoire() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_PIECE);
        Piece piece = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece);
    }

    @Test
    public void testGenererPieceCyclique() {
        UsineDePiece.setMode(UsineDePiece.CYCLIC);
        Piece piece1 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece1);
        Assertions.assertTrue(piece1 instanceof OPiece);
        Piece piece2 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece2);
        Assertions.assertTrue(piece2 instanceof IPiece);
        Piece piece3 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece3);
        Assertions.assertTrue(piece3 instanceof LPiece);
        Piece piece4 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece4);
        Assertions.assertTrue(piece4 instanceof SPiece);
        Piece piece5 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece5);
        Assertions.assertTrue(piece5 instanceof TPiece);
        Piece piece6 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece6);
        Assertions.assertTrue(piece6 instanceof ZPiece);
    }

    @Test
    public void testGenererPieceAleatoireComplet() {
        UsineDePiece.setMode(UsineDePiece.ALEATOIRE_COMPLET);
        Piece piece1 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece1);
        Assertions.assertTrue(piece1 instanceof OPiece);
        Piece piece2 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece2);
        Assertions.assertTrue(piece2 instanceof IPiece);
        Piece piece3 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece3);
        Assertions.assertTrue(piece3 instanceof LPiece);
        Piece piece4 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece4);
        Assertions.assertTrue(piece4 instanceof SPiece);
        Piece piece5 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece5);
        Assertions.assertTrue(piece5 instanceof TPiece);
        Piece piece6 = UsineDePiece.genererPiece();
        Assertions.assertNotNull(piece6);
        Assertions.assertTrue(piece6 instanceof ZPiece);
    }

}
