uururçuçhççuhuçuçhuçhuhuhpackage fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.IPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.JPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.LPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.OPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.SPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.TPiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.ZPiece;

public class UsineDePiece {

	public static final int CYCLIC = 1;
	public static final int ALEATOIRE_COMPLET = 2;
	public static final int ALEATOIRE_PIECE = 3;

	private static Random randCoul = new Random();
	// public static Coordonnees new Coordonnees(2,3) = new Coordonnees(2, 3);
	private static int nbPieceUsine = 0;

	static int mode = ALEATOIRE_PIECE;

	private UsineDePiece() {

	}

	public static void setMode(int mode) {
		UsineDePiece.mode = mode;
		if (UsineDePiece.mode == UsineDePiece.CYCLIC) {
			nbPieceUsine = 0;
			mode = ALEATOIRE_PIECE;
		}
	}
	
	public static Piece modeCyclic() {
		Piece[] tab = new Piece[7] ;
			tab[0] = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
			tab[1] = new IPiece(new Coordonnees(2, 3), Couleur.ORANGE);
			tab[2] = new 	TPiece(new Coordonnees(2, 3), Couleur.BLEU);
			tab[3] = new LPiece(new Coordonnees(2, 3), Couleur.VERT);
			tab[4] = new JPiece(new Coordonnees(2, 3), Couleur.JAUNE);
			tab[5] = new ZPiece(new Coordonnees(2, 3), Couleur.CYAN);
			tab[6] = new SPiece(new Coordonnees(2, 3), Couleur.VIOLET);		
		return tab[nbPieceUsine % 7];
	}
	public static Piece modeAleatoirePiece() {
		Piece[] tab = new Piece[7] ;
		tab[0] = new OPiece(new Coordonnees(2, 3), Couleur.ROUGE);
		tab[1] = new IPiece(new Coordonnees(2, 3), Couleur.ORANGE);
		tab[2] = new TPiece(new Coordonnees(2, 3), Couleur.BLEU);
		tab[3] = new LPiece(new Coordonnees(2, 3), Couleur.VERT);
		tab[4] = new JPiece(new Coordonnees(2, 3), Couleur.JAUNE);
		tab[5] = new ZPiece(new Coordonnees(2, 3), Couleur.CYAN);
		tab[6] = new SPiece(new Coordonnees(2, 3), Couleur.VIOLET);
		return tab[randCoul.nextInt(7)];
	}
	public static Piece modeAleatoireComplet() {
		Piece[] tab = new Piece[7] ;
		int nbCoul = randCoul.nextInt(Couleur.values().length);	
		tab[0] = new OPiece(new Coordonnees(2, 3), Couleur.values()[nbCoul]);
		tab[1] = new IPiece(new Coordonnees(2, 3), Couleur.values()[nbCoul]);
		tab[2] = new 	TPiece(new Coordonnees(2, 3), Couleur.values()[nbCoul]);
		tab[3] = new LPiece(new Coordonnees(2, 3), Couleur.values()[nbCoul]);
		tab[4] = new JPiece(new Coordonnees(2, 3), Couleur.values()[nbCoul]);
		tab[5] = new ZPiece(new Coordonnees(2, 3), Couleur.values()[nbCoul]);
		tab[6] = new SPiece(new Coordonnees(2, 3), Couleur.values()[nbCoul]);
		return tab[randCoul.nextInt(7)];
	}

	public static Piece genererPiece() {
		Piece piece = null;
		switch (mode) {
		case CYCLIC:
				piece = modeCyclic();
				nbPieceUsine++;
				break;	
		case ALEATOIRE_PIECE:
				piece = modeAleatoirePiece();
				break;
		case ALEATOIRE_COMPLET:
			    piece = modeAleatoireComplet();
			    break;
		default:
			System.out.println("AUCUN MODE TROUVE");
		}
		return piece;
	}
}
