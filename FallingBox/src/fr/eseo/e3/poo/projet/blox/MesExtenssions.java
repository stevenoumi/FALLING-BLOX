package fr.eseo.e3.poo.projet.blox;

import javax.swing.JLabel;

import fr.eseo.e3.poo.projet.blox.modele.Coordonnees;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class MesExtenssions{
	
	private Puits puits;
	public int score;
	public int lignescore;

	public  int meilleurScore;
	public int lignesSupprimees = 0;
	public int compteurLigne = 0;
	
	
	public JLabel scoreLabel = new JLabel("Score: 0");
	public JLabel meilleurScoreLabel = new JLabel("Meilleur score: 0");
	 public MesExtenssions(Puits puits){
		this.puits = puits;
		this.lignesSupprimees = 0;
		this.score = 0;
		this.lignescore = 0;
		meilleurScore = 0;

	}
	 public int getScore() {
			return this.score;
		}
	 
		public void cleanTas() {
			int derniereLigne = this.puits.getTas().getPuits().getProfondeur() - 1;
			boolean lignePleine = false;
			 // nouvelle variable pour compter le nombre de lignes supprimées
			for (int i = derniereLigne; i >= 0; i--) {
				boolean estPlein = true;
				for (int j = 0; j < this.puits.getTas().getPuits().getLargeur(); j++) {
					if (this.puits.getTas().getElements()[i][j] == null) {
						estPlein = false;
						break;
					}
				}
				if (estPlein) {
				int a = suprimeLigne( i);
				lignescore++; // Incrémente le nombre de lignes supprimées
				lignePleine = true;
				lignesSupprimees += lignescore;
			
			}
			if (lignePleine ) {
				miseAJourScore(lignescore); // met à jour le score en fonction du nombre de lignes supprimées
				cleanTas();
				lignescore = 0;
				this.compteurLigne ++;
				meilleurScoreLabel.setText("Score: " + this.score);
				lignescore = 0;


			}
			
		}
		}
		public int suprimeLigne(int i) {
				for (int k = i; k > 0; k--) {
					for (int j = 0; j < this.puits.getTas().getPuits().getLargeur(); j++) {
						this.puits.getTas().getElements()[k][j] = this.puits.getTas().getElements()[k - 1][j];
					}
				}
				for (int j = 0; j < this.puits.getTas().getPuits().getLargeur(); j++) {
					this.puits.getTas().getElements()[0][j] = null;
				}	
				return 0;
			}
		



		public void miseAJourScore(int a) {
			int points = 0;
			switch (a) {
			case 1:
				points = 10;
				break; 
			case 2:
				points = 25;
				break;
			case 3:
				points = 50;
				break;
			case 4:
				points = 100;
				break;
			default:
				break;
			}
			this.score += points;
			if(this.score > meilleurScore)
				this.meilleurScore = score;
		}

		public void echangerPiece() {
			Coordonnees old = this.puits.getPieceActuelle().getElements().get(0).getCoordonnees();
			if (this.puits.getPieceActuelle() != null && this.puits.getPieceSuivante() != null) {
				this.puits.setPieceSuivante(this.puits.getPieceActuelle());
				this.puits.getPieceActuelle().setPosition(old.getAbscisse(),old.getOrdonnee());
				this.puits.getPieceSuivante().setPosition( 2,3);
	  
			}
		}

}