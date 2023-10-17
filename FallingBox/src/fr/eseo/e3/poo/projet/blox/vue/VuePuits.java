package fr.eseo.e3.poo.projet.blox.vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import fr.eseo.e3.poo.projet.blox.controleur.Gravite;
import fr.eseo.e3.poo.projet.blox.controleur.PieceDeplacement;
import fr.eseo.e3.poo.projet.blox.controleur.PieceRotation;
import fr.eseo.e3.poo.projet.blox.controleur.ToucheClavier;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

@SuppressWarnings("serial")
public class VuePuits extends JPanel implements PropertyChangeListener {

	public static final int TAILLE_PAR_DEFAUT = 15;

	private VuePiece vuePiece;
	private Puits puits;
	private int taille;
	private final VueTas vueTas;
	private Gravite gravite;

	public VuePuits(Puits puits) {

		this(puits, TAILLE_PAR_DEFAUT); 
		this.gravite = new Gravite(this);
		}

	public VuePuits(Puits puits, int taille) {
		super();
		this.puits = puits;
		this.taille = taille;
		this.vueTas = new VueTas(this);
		super.setPreferredSize(
				new Dimension(this.taille * puits.getLargeur(), this.taille * this.puits.getProfondeur()));
		this.setBackground(Color.WHITE);
		this.puits.addPropertyChangeListener(this);
		PieceDeplacement pieceDeplacement = new PieceDeplacement(this);
		PieceRotation pieceRotation = new PieceRotation(this);
	    ToucheClavier toucheClavier = new ToucheClavier(this);
		this.addMouseListener(pieceDeplacement);
		this.addMouseListener(pieceRotation);
		this.addMouseMotionListener(pieceDeplacement);
		this.addMouseWheelListener(pieceDeplacement);
		 this.addKeyListener(toucheClavier);
		    setFocusable(true);

	}
//	public void incrementeScore(int points) {
//	    puits.score += points;
//	    if (puits.score >= 500) {
//	        this.getGravite().setPeriodicite(this.getGravite().getPeriodicite() - 10);
//	    }
//	} 


	public Puits getPuits() {
		return this.puits;
	}
	public Gravite getGravite() {
		return this.gravite;
	}

	public int getTaille() {

		return this.taille;
	}

	public VuePiece getVuePiece() {
		return this.vuePiece;
	}

	public VueTas getVueTas() {
		return this.vueTas;
	}

	public void setPuits(Puits puits) {
		this.puits = puits;
		super.setPreferredSize(
				new Dimension(this.taille * puits.getLargeur(), this.taille * this.puits.getProfondeur()));
//		this.revalidate(); // on demande une nouvelle dispôsition des composants
	}

	public void setTaille(int taille) {
		this.taille = taille;
		super.setPreferredSize(
				new Dimension(this.taille * puits.getLargeur(), this.taille * this.puits.getProfondeur()));
//		this.revalidate(); // cette instruction permet de demander une nouvelle disposition des composants
	}

	private void setVuePiece(VuePiece vuePiece) {
		this.vuePiece = vuePiece;
	}

	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		Graphics2D g2D = (Graphics2D) g.create();

		g2D.setColor(Color.LIGHT_GRAY);
		
			int x, y;
			for (y = 0; y <= puits.getProfondeur(); y++) {
				for (x = 0; x <= puits.getLargeur(); x++) {
					g2D.drawLine(x * taille, y * taille,(x+1)*taille,y*taille);
					g2D.drawLine(x*taille, y*taille,x*taille,(y+1)*taille);
				}
			}
			if (vuePiece != null) {
				this.vuePiece.afficherPiece(g2D);
			}
			if (this.vueTas != null) {
				this.vueTas.afficher(g2D);
				// this.setBackground(null);


			}
			repaint();
		g2D.dispose();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		System.out.println(evt.getPropertyName());
		if (propertyName.equals(Puits.MODIFICATION_PIECE_ACTUELLE)) {
			Piece newPiece = (Piece) evt.getNewValue();
			if (newPiece != null) {
				setVuePiece(new VuePiece(newPiece, taille));
			}
		}
	}

	
}