package fr.eseo.e3.poo.projet.blox.modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

import fr.eseo.e3.poo.projet.blox.GameOver;
import fr.eseo.e3.poo.projet.blox.MesExtenssions;
import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Puits {

	private Piece pieceActuelle;
	private Piece pieceSuivante;
	private PropertyChangeSupport pcs;
	private Tas tas;
	public static final int LARGEUR_PAR_DEFAUT = 15;
	public static final int PROFONDEUR_PAR_DEFAUT = 25;
	public static final String MODIFICATION_PIECE_ACTUELLE = "modification piece actuelle";
	public static final String MODIFICATION_PIECE_SUIVANTE = "modification piesse suivante";
	private int profondeur;
	private int largeur;
	private MesExtenssions extenssions;
	public Puits() {
		this(LARGEUR_PAR_DEFAUT, PROFONDEUR_PAR_DEFAUT);
		
		pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);

	}

	public Puits(int largeur, int profondeur) {
		this.setLargeur(largeur);
		this.setProfondeur(profondeur);
		pcs = new PropertyChangeSupport(this);
		this.tas = new Tas(this);
		this.extenssions = new MesExtenssions(this);

	}

	public Puits(int largeur, int profondeur, int nbElements, int nbLignes) {
		this.setLargeur(largeur);
		this.setProfondeur(profondeur);
		this.tas = new Tas(this, nbElements, nbLignes);
		

	}

	public Piece getPieceActuelle() {
		return this.pieceActuelle;
	}

	public Piece getPieceSuivante() {
		return this.pieceSuivante;
	}

	public int getProfondeur() {
		return this.profondeur;
	}

	public int getLargeur() {
		return this.largeur;
	}

	public Tas getTas() {
		return this.tas;
	}

	

	private void gererCollision() {
		if (this.pieceActuelle != null) {
			try {
			this.tas.ajouterElements(pieceActuelle);
			this.extenssions.cleanTas();
			this.extenssions.scoreLabel.setText("Score: " + this.extenssions.score);

			this.setPieceSuivante(UsineDePiece.genererPiece());
			}catch (ArrayIndexOutOfBoundsException e) {
				new GameOver();				
				// TODO: handle exception
			}
		}
	}
	public void gravite() {
		try {
			if (this.pieceActuelle != null) {
				this.pieceActuelle.deplacerDe(0, 1);
			}
		} catch (BloxException e1) {
			this.gererCollision();

		}
	}

	public void setPieceSuivante(Piece piece) {
		Piece anciennePieceActuelle = this.pieceActuelle;
		Piece anciennePieceSuivante = this.pieceSuivante;

		if (this.pieceSuivante != null) {
			this.pieceActuelle = this.pieceSuivante;
			this.pieceActuelle.setPosition((this.largeur / 2), -4);
			pcs.firePropertyChange(MODIFICATION_PIECE_ACTUELLE, anciennePieceActuelle, anciennePieceSuivante);

		}
		this.pieceSuivante = piece;
		pcs.firePropertyChange(MODIFICATION_PIECE_SUIVANTE, anciennePieceSuivante, piece);
	
		this.pieceSuivante.setPuits(this);
		
	}

	public void setProfondeur(int profondeur) {
		if (profondeur < 15 || profondeur > 25)
			throw new IllegalArgumentException("profondeur hors de bornes");
		else
			this.profondeur = profondeur;
	}

	public void setLargeur(int largeur) {
		if (largeur < 5 || largeur > 15)
			throw new IllegalArgumentException("largeur hors de bornes");
		else
			this.largeur = largeur;
	}

	public void setTas(Tas tas) {
		this.tas = tas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(largeur, pieceActuelle, pieceSuivante, profondeur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Puits other = (Puits) obj;
		return largeur == other.largeur && Objects.equals(pieceActuelle, other.pieceActuelle)
				&& Objects.equals(pieceSuivante, other.pieceSuivante) && profondeur == other.profondeur;
	}

	@Override
	public String toString() {
		String a = "Puits : Dimension " + this.largeur + " x " + this.profondeur + "\n" + "Piece Actuelle : ";
		if (this.pieceActuelle == null)
			a += "<aucune>" + "\n";
		else
			a += this.pieceActuelle.toString();
 
		a += "Piece Suivante : ";

		if (this.pieceSuivante == null)
			a += "<aucune>" + "\n";
		else
			a += this.pieceSuivante.toString();

		return a;
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		if (pcs == null) {
			pcs = new PropertyChangeSupport(this);
		}
		pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		if (pcs != null) {
			pcs.removePropertyChangeListener(listener);
		}
	}

	public void setPieceActuelle(Piece genererPiece) {
		// TODO Auto-generated method stub
		this.pieceActuelle = genererPiece;

	}

	public PropertyChangeSupport getPuitsPcs() {
		// TODO Auto-generated method stub
		return this.pcs;
	}
	public MesExtenssions getExtenssions() {
		return this.extenssions;
	}

	public PropertyChangeSupport getPropertyChangeListeners() {
		// TODO Auto-generated method stub
		return pcs;
	}

}
