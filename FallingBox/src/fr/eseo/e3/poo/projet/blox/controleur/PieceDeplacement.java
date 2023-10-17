package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import fr.eseo.e3.poo.projet.blox.modele.BloxException;
import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class PieceDeplacement extends MouseAdapter  {

  private VuePuits vuePuits;
  private Puits puits;
  private int derniereColonne;

  public PieceDeplacement(VuePuits vuePuits) {
    this.vuePuits = vuePuits;
    this.puits = vuePuits.getPuits();
    this.derniereColonne = -1;

  }

  @Override
  public void mouseMoved(MouseEvent event) {
    if (this.puits.getPieceActuelle() != null) {
      int colonneSouris = event.getX() / vuePuits.getTaille();
      if (derniereColonne == -1) {
        derniereColonne = colonneSouris;
      } else if (colonneSouris != derniereColonne) {
    	  int a =colonneSouris - derniereColonne;
        try {
        	if(a > 0)
        		this.puits.getPieceActuelle().deplacerDe(1,0);
        	else
        		this.puits.getPieceActuelle().deplacerDe(-1,0);
          derniereColonne = colonneSouris;
          vuePuits.repaint();
        } catch (IllegalArgumentException e) {
          // Ne rien faire si le déplacement lève une exception
        	System.out.println("erreur de deplacement");
        } catch (BloxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    }
  }
  public void mouseWheelMoved(MouseWheelEvent event) {
	    if (this.puits.getPieceActuelle() != null && event.getWheelRotation()>0) {
	    	try {
				this.puits.getPieceActuelle().deplacerDe(0, 1);
			} catch (BloxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
        vuePuits.repaint();

	  }

  @Override
  public void mouseDragged(MouseEvent event) {
   this.derniereColonne = -1;
  }
  public void mouseEntered(MouseEvent event) {
	  derniereColonne = -1;
  }
 
}
