package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.Tas;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceRotation extends MouseAdapter {

	private VuePuits vuePuits;
	private Puits puits;
	@SuppressWarnings("unused")
	private Tas tas;

	public PieceRotation(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = vuePuits.getPuits();
		this.tas = this.puits.getTas();
	}

	public void mouseTourner(boolean b) {
		try {
			this.puits.getPieceActuelle().tourner(b);
		} catch (BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void mouseClicked(MouseEvent event) {

		if (SwingUtilities.isRightMouseButton(event)) {
			mouseTourner(true);
		} else if (SwingUtilities.isLeftMouseButton(event)) {
			mouseTourner(false);
		} else if (SwingUtilities.isMiddleMouseButton(event) && this.puits != null) {
		
			vuePuits.repaint();
		}
	}

}