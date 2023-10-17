package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Tas;

public class VueTas {

	public static final double MULTIPLIER_NUANCE = 0.4;

	private final Tas tas;
	private final VuePuits vuePuits;

	public VueTas(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		//this.tas = new Tas(this.vuePuits.getPuits());
		this.tas = this.vuePuits.getPuits().getTas();

	}

	public Color nuance(Color couleur) {
		// Récupérer les valeurs entières des composants rouge, vert et bleu
	    int red = couleur.getRed();
	    int green = couleur.getGreen();
	    int blue = couleur.getBlue();

	    // Calculer la nouvelle valeur pour chaque composante
	    red = (int) Math.round(red * (1 - MULTIPLIER_NUANCE));
	    green = (int) Math.round(green * (1 - MULTIPLIER_NUANCE));
	    blue = (int) Math.round(blue * (1 - MULTIPLIER_NUANCE));

	    // Créer une nouvelle instance de la classe Color avec les nouvelles valeurs
	    return new Color(red, green, blue);
	}

	public void afficher(Graphics2D g2D) {
	
			for (int i = 0; i < this.tas.getElements().length; i++) {
				for (int j = 0; j < this.tas.getElements()[i].length; j++) {
					if (this.tas.getElements()[i][j] != null) {
						Color couleur = this.tas.getElements()[i][j].getCouleur().getCouleurPourAffichage();
						Color couleurNuancee = nuance(couleur);
						g2D.setColor(couleurNuancee);
						g2D.setBackground(Color.WHITE);
						int x = this.vuePuits.getTaille() * j;
						int y = this.vuePuits.getTaille() * i ;
						g2D.fill3DRect(x, y, this.vuePuits.getTaille(), this.vuePuits.getTaille(), true);
					}
				}
			}
		}

	

	public VuePuits getVuePuits() {
		return this.vuePuits;
	}

}
