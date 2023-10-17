package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotationTest {

	private VuePuits vuePuits;

	public static void main(String[] args) {
		PieceRotationTest prt = new PieceRotationTest();
		prt.testConstructeurPuits();
	}

	private void testConstructeurPuits() {
		Puits puits = new Puits();

		// Exercises du 3.3.9
		vuePuits = new VuePuits(puits);
		UsineDePiece.setMode(3);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.getPieceActuelle().setPosition(5, 5);
		JFrame frame = new JFrame("Puits pieceRotation");
		frame.add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();

	}
}
