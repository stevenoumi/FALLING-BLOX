package fr.eseo.e3.poo.projet.blox.modele.pieces;

import java.util.ArrayList;
import java.util.List;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Couleur;
import fr.eseo.e3.poo.projet.blox.modele.Element;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public abstract class Piece {

	private List<Element> elements;
	private Puits puits;

	public Piece(Coordonnees cord, Couleur coul) {
		this.elements = new ArrayList<>();
		this.setElements(cord, coul);
	}

	protected abstract void setElements(Coordonnees cord, Couleur coul);

	public List<Element> getElements() {
		return this.elements;

	}

	public void setPosition(int abs, int odr) {
		setElements(new Coordonnees(abs, odr), this.getElements().get(0).getCouleur());
	}

	public Puits getPuits() {
		return this.puits;
	}

	public void setPuits(Puits puits) {

		this.puits = puits;
	}

	public void deplacerDe(int dx, int dy) throws BloxException {
		if (dx > 1 || dy > 1 || dy < 0) {
			throw new IllegalArgumentException("le deplacement ne peut s'effectuer ");
		} else {
			for (Element element : elements) {
				int newX = element.getCoordonnees().getAbscisse() + dx;
				int newY = element.getCoordonnees().getOrdonnee() + dy;
				collision(newX, newY);
			}
			for (Element element : elements) {
				element.deplacerDe(dx, dy);
			}
		}
	}

	public void tourner(boolean sensHoraire) throws BloxException {
		Element ref = elements.get(0);
		int refX = ref.getCoordonnees().getAbscisse();
		int refY = ref.getCoordonnees().getOrdonnee();
		int[] tabX = new int[elements.size()];
		int[] tabY = new int[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			Element element = elements.get(i);
			int dx = element.getCoordonnees().getAbscisse() - refX;
			int dy = element.getCoordonnees().getOrdonnee() - refY;
			int newX, newY;
			if (sensHoraire) {
				newX = -dy;
				newY = dx;
			} else {
				newX = dy;
				newY = -dx;
			}
			collision (newX + refX,newY + refY);
			tabX[i] = newX + refX;
			tabY[i] = newY + refY;
		}
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).setCoordonnees(new Coordonnees(tabX[i], tabY[i]));
		}
	}
	public void collision(int a,int b) throws BloxException {
		if (puits != null) {
			if (a < 0 ||a >= puits.getLargeur()) {
				throw new BloxException("La pièce sort du puits", BloxException.BLOX_SORTIE_PUITS);
			}else if(b >= puits.getProfondeur()) {
				throw new BloxException("La pièce sort du puits", BloxException.BLOX_COLLISION);
			} else if (b >= 0 && puits.getTas().getElements()[b][a] != null) {
				throw new BloxException("Collision de pièces", BloxException.BLOX_COLLISION);
			}
		}
	}

	@Override
	public String toString() {
		String a = "Piece :\n";
		for (int i = 0; i < this.elements.size(); i++) {
			a += "\t" + getElements().get(i).toString();
		}

		return a;
	}
}