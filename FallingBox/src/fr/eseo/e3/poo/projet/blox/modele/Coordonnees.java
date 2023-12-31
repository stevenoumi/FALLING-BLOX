package  fr.eseo.e3.poo.projet.blox.modele;

import java.util.Objects;

public class Coordonnees{
	
	private int abscisse;
	private int ordonnee;
	
	//constructeur
	
	public Coordonnees(int abscisse, int ordonnee){
		this.abscisse = abscisse;
		this.ordonnee = ordonnee;
	}
	
	public int  getAbscisse(){
		return this.abscisse;
	}
	public int getOrdonnee() {
		return this.ordonnee;
	}
	public void setOrdonnee(int ord) {
		this.ordonnee = ord;
	}
	public void setAbscisse(int abs) {
		this.abscisse = abs;
	}
	
	public String toString() {
		return "(" + this.abscisse + ", " + this.ordonnee + ")";
	}

	@Override
	public int hashCode() {
		return Objects.hash(abscisse, ordonnee);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordonnees other = (Coordonnees) obj;
		return abscisse == other.abscisse && ordonnee == other.ordonnee;
	}
	
}