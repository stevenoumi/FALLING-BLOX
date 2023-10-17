package fr.eseo.e3.poo.projet.blox.vue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePuitsAffichageTest {

	private VuePuits vuePuits;
	

	// code de base
	public VuePuitsAffichageTest() {
		testConstructeurPuits();
		testConstructeurPuitsTaille();
	}

	private void testConstructeurPuits() {

		// Exercises du 3.3.9
		Puits puits = new Puits();
		vuePuits  = new VuePuits(puits);
		Piece piece = UsineDePiece.genererPiece();
		puits.setPieceSuivante(piece);
		puits.setPieceSuivante(piece);
		puits.setTas(null);
		UsineDePiece.setMode(3);
		//VuePiece vuePiece = new VuePiece(piece, vuePuits.TAILLE_PAR_DEFAUT);
		//vuePuits.setVuePiece(vuePiece);  	
		JFrame frame = new JFrame("Puits");
		frame.add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			frame.repaint();

	}
	
	

	private void testConstructeurPuitsTaille() {
		JFrame frame = new JFrame("Puits et taille");
		
		Piece piece = UsineDePiece.genererPiece();
		//MouseEvent evt = new MouseEvent(vuePuits, 0, 0, 0, 0, 0, 0, 0, 0, false, 0);

		try {
			piece.tourner(false);
		} catch (BloxException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		Puits puits = new Puits();	
		UsineDePiece.setMode(3);
		vuePuits = new VuePuits(puits);
		vuePuits.getPuits().setPieceSuivante(piece);
		vuePuits.getPuits().setPieceSuivante(piece);
		vuePuits.getPuits().getPieceActuelle().setPosition(5, 5);
		try {
			vuePuits.getPuits().getPieceActuelle().deplacerDe(1, 0);
		} catch (BloxException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			vuePuits.getPuits().getPieceActuelle().deplacerDe(1, 0);
		} catch (BloxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			vuePuits.getPuits().getPieceActuelle().deplacerDe(1, 0);
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(vuePuits);
		frame.pack();
		frame.setVisible(true);
		frame.repaint(); 
		 
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VuePuitsAffichageTest();
			}
		});
	}
}
