package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class ToucheClavier extends KeyAdapter {
	private Puits puits;
	@SuppressWarnings("unused")
	private VuePuits vuePuits;

	public ToucheClavier(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			try {
				this.puits.getPieceActuelle().tourner(true);
			} catch (BloxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			try {
				this.puits.getPieceActuelle().tourner(false);
			} catch (BloxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			this.puits.getExtenssions().echangerPiece();

		} else
			deplacement(e);

	}

	public void deplacement(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			try {
				this.puits.getPieceActuelle().deplacerDe(-1, 0);
			} catch (BloxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			try {
				this.puits.getPieceActuelle().deplacerDe(1, 0);
			} catch (BloxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
