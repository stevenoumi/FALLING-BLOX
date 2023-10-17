package fr.eseo.e3.poo.projet.blox.modele.pieces;


import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;

public class LPiece extends Piece {
	
	
	
	public LPiece (Coordonnees cord, Couleur coul) {
		super(cord, coul);
		this.setElements(cord, coul);
	}
	protected void setElements(Coordonnees cord, Couleur coul) {
		//this.getElements().add(new Element(cord,coul));
		super.getElements().clear();
		super.getElements().add(new Element(new Coordonnees(cord.getAbscisse(),cord.getOrdonnee()), coul));
		super.getElements().add(new Element(new Coordonnees(cord.getAbscisse()+1,cord.getOrdonnee()), coul));
		super.getElements().add(new Element(new Coordonnees(cord.getAbscisse(),cord.getOrdonnee()-1), coul));
		super.getElements().add(new Element(new Coordonnees(cord.getAbscisse(),cord.getOrdonnee()-2), coul));

	}
	@Override
	public String toString() {
		String a = "LPiece :\n";
		for(int i = 0; i< super.getElements().size(); i++) {
			a+="\t" + getElements().get(i).toString() + "\n";
		}
		
		return a;
	}
	
}