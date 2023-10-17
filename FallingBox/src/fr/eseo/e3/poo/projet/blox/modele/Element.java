package  fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Element{
	
	private Coordonnees coordonnees;
	private Couleur couleur;

	public Element(Coordonnees coordonnees) {
		
		this.coordonnees = coordonnees;
		this.couleur = Couleur.values()[0];
		
	}
	
	public Element(int abs, int ord) {
		
		this.setCoordonnees(new Coordonnees(abs, ord));
		this.couleur = Couleur.values()[0];

	
	}
	
	public Element(int abs, int odr, Couleur coul) {
		
		this.setCoordonnees(new Coordonnees(abs, odr));
		this.couleur = coul;
	}
public Element(Coordonnees cord, Couleur coul) {

		this.coordonnees = cord;
		this.couleur = coul;
	}
	public Coordonnees getCoordonnees() {
		return this.coordonnees;
	}
	public Couleur getCouleur() {
		return this.couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	
	public void setCoordonnees(Coordonnees cord) {
		this.coordonnees = cord;
	}
	
	public String toString() {
		return this.coordonnees.toString() + " - " + this.couleur;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(coordonnees, couleur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Element other = (Element) obj;
		return Objects.equals(coordonnees, other.coordonnees) && couleur == other.couleur;
	}
	public void deplacerDe(int dx, int dy) {
		
		this.setCoordonnees(new Coordonnees(this.coordonnees.getAbscisse()+ dx,this.coordonnees.getOrdonnee()+ dy));
	}


	}