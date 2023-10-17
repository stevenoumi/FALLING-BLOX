package fr.eseo.e3.poo.projet.blox.modele;

import java.util.Random;

import fr.eseo.e3.poo.projet.blox.modele.pieces.Piece;

public class Tas {
	private Element[][] elements;
	private Puits puits;
	private int nbElementPlace = 0;

	public Tas(Puits puits) {
		this.puits = puits;
		this.elements = new Element[puits.getProfondeur()][puits.getLargeur()];
		// création d'un tas vide
		this.construireTas(0, 0, new Random());
	}

	public Tas(Puits puits, int nbElements) {
		this(puits);
		int nbLignes = (nbElements / puits.getLargeur()) + 1;
		Random random = new Random();
		this.construireTas(nbElements, nbLignes, random);
	}

	public Tas(Puits puits, int nbElements, int nbLignes) {
		this(puits);
		int tailleMax = puits.getLargeur() * nbLignes;
		if (nbElements <= 0 || nbElements > tailleMax) {
			throw new IllegalArgumentException(
					"Le nombre d'éléments doit être compris entre 1 et la taille maximale du puits.");
		}
		this.construireTas(nbElements, nbLignes, new Random());
	}

	public Puits getPuits() {
		return this.puits;
	}

	public Element[][] getElements() {
		return this.elements;
	}

	public int getNombreElements() {
		return this.nbElementPlace;
	}

	public void ajouterElements(Piece piece) {
		for (int i = 0; i < piece.getElements().size(); i++) {
			
			int x = piece.getElements().get(i).getCoordonnees().getAbscisse();
			int y = piece.getElements().get(i).getCoordonnees().getOrdonnee();
			if(y >    this.puits.getProfondeur()  ) {
				throw new ArrayIndexOutOfBoundsException();
			}else
			this.elements[y][x] = piece.getElements().get(i);
		}
	}



	private void construireTas(int nbElements, int nbLigne, Random rand) {
		int tailleMax = this.puits.getLargeur() * nbLigne;
		if (nbElements < 0 || nbElements > tailleMax) {
			throw new IllegalArgumentException("Erreur dans la construction du tas");
		}

		int ord;
		int abs;
		int indiceCouleur;
		while (nbElementPlace < nbElements) {
			ord = this.getPuits().getProfondeur() - (rand.nextInt(nbLigne) + 1);
			abs = rand.nextInt(this.puits.getLargeur());
			if (this.elements[ord][abs] == null) {
				indiceCouleur = rand.nextInt(Couleur.values().length);
				this.elements[ord][abs] = new Element(new Coordonnees(abs, ord), Couleur.values()[indiceCouleur]);
				nbElementPlace++;
			}
		}
	}
}
