package fr.eseo.e3.poo.projet.blox;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.UsineDePiece;
import fr.eseo.e3.poo.projet.blox.vue.PanneauInformation;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class FallingBloxV2 {

	private VuePuits vuePuits;

	public static void main(String[] args) {
		FallingBloxV2 pdt = new FallingBloxV2();
		pdt.testConstructeurPuits();
	}

	private void testConstructeurPuits() {

		// Exercises du 3.3.9
		Puits puits = new Puits();
		vuePuits = new VuePuits(puits);
		
		UsineDePiece.setMode(3);
		PanneauInformation pan = new PanneauInformation(puits);
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.setPieceSuivante(UsineDePiece.genererPiece());
		puits.getPieceActuelle().setPosition(5, 0);	
		System.out.println(vuePuits.getGravite().getPeriodicite());
		JFrame frame = new JFrame("Tetris");
		
		frame.add(vuePuits);
		frame.add(pan, BorderLayout.EAST);
		frame.add(puits.getExtenssions().scoreLabel,BorderLayout.NORTH);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
		
		/// il faudrait lancer avec tomcat de java
		//transformer le jar en war

	}

}