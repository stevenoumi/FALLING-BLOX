package fr.eseo.e3.poo.projet.blox.controleur;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacementTest {

	private VuePuits vuePuits;

	public static void main(String[] args) {
		PieceDeplacementTest pdt = new PieceDeplacementTest();
		pdt.testConstructeurPuits();
	}

	private void testConstructeurPuits() {

		// Exercises du 3.3.9
		Puits puits = new Puits();
		vuePuits = new VuePuits(puits);
		UsineDePiece.setMode(3);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.getPieceActuelle().setPosition(5, 5);
		System.out.println(puits.getPieceActuelle());
		System.out.println(vuePuits.getPuits().getPieceActuelle());
		JFrame frame = new JFrame("Puits pieceDeplavement");
		frame.add(vuePuits);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();

	}
}
