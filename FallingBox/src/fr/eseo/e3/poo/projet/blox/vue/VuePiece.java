package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class VuePiece  {

	private final int taille;
	private final Piece piece;

	public static final double MULTIPLIER_TEINTE = 0.3;

	public VuePiece(Piece piece, int taille) {
		this.taille = taille;
		this.piece = piece;
	}

	public Color teinte(Color couleur) {
		int red = couleur.getRed();
		int green = couleur.getGreen();
		int blue = couleur.getBlue();

		red += (int) ((255 - red) * MULTIPLIER_TEINTE);
		green += (int) ((255 - green) * MULTIPLIER_TEINTE);
		blue += (int) ((255 - blue) * MULTIPLIER_TEINTE);

		red = Math.min(255, red);
		green = Math.min(255, green);
		blue = Math.min(255, blue);

		return new Color(red, green, blue);
	}

	public void afficherPiece(Graphics2D g2D) {
		
		// Récupérer la couleur de la pièce
		Coordonnees cord0,cord1,cord2,cord3;
cord0=new Coordonnees(this.piece.getElements().get(0).getCoordonnees().getAbscisse(),this.piece.getElements().get(0).getCoordonnees().getOrdonnee());
cord1=new Coordonnees(this.piece.getElements().get(1).getCoordonnees().getAbscisse(),this.piece.getElements().get(1).getCoordonnees().getOrdonnee());
cord2=new Coordonnees(this.piece.getElements().get(2).getCoordonnees().getAbscisse(),this.piece.getElements().get(2).getCoordonnees().getOrdonnee());
cord3=new Coordonnees(this.piece.getElements().get(3).getCoordonnees().getAbscisse(),this.piece.getElements().get(3).getCoordonnees().getOrdonnee());
		
		Color couleur = this.piece.getElements().get(0).getCouleur().getCouleurPourAffichage();
			
		g2D.setColor(couleur);
			g2D.fill3DRect(cord1.getAbscisse()*taille, cord1.getOrdonnee()*taille, this.taille, this.taille, true);
			g2D.fill3DRect(cord2.getAbscisse()*taille, cord2.getOrdonnee()*taille, this.taille, this.taille, true);			
			g2D.fill3DRect(cord3.getAbscisse()*taille, cord3.getOrdonnee()*taille, this.taille, this.taille, true);			
			g2D.setColor(teinte(couleur));
			g2D.fill3DRect(cord0.getAbscisse()*taille, cord0.getOrdonnee()*taille, this.taille, this.taille, true);
			


	}

}
