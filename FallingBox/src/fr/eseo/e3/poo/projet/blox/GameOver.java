package fr.eseo.e3.poo.projet.blox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class GameOver extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VuePuits vuePuits;

	public GameOver() {
        JLabel label = new JLabel("Game Over");
        label.setFont(label.getFont().deriveFont(56.0f)); // changer la taille de police
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);// centre le texte
        this.getContentPane().add(label);
        this.pack(); // redimensionne la fenêtre pour s'adapter à son contenu
        this.setLocationRelativeTo(null); // centre la fenêtre sur l'écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ferme l'application lorsque la fenêtre est fermée
        this.setVisible(true); // affiche la fenêtre
        this.vuePuits.getGravite().getTimer().stop();// affiche la fenêtre

    }

}
