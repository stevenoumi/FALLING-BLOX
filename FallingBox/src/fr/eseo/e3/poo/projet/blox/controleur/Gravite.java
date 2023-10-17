package fr.eseo.e3.poo.projet.blox.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import fr.eseo.e3.poo.projet.blox.modele.Puits;
import fr.eseo.e3.poo.projet.blox.vue.VuePuits;

public class Gravite implements ActionListener {

	private final VuePuits vuePuits;
	private final Puits puits;
	private Timer timer;
	public static final int PERIODICITE_INITIALE = 500;

	public Gravite(VuePuits vuePuits) {
		this.vuePuits = vuePuits;
		this.puits = this.vuePuits.getPuits();
		this.timer = new Timer(PERIODICITE_INITIALE, this);
		this.timer.start();
	}

	public int getPeriodicite() {
		return this.timer.getDelay();
	}

	public void setPeriodicite(int periodicite) {
		this.timer.setDelay(periodicite);
	}

	public Timer getTimer() {
		return this.timer;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.puits.gravite();
		this.accelerer();

	}

	public void accelerer() {
		if (this.puits.getExtenssions().compteurLigne > 0 && this.puits.getExtenssions().compteurLigne % 2 == 0) {
			this.puits.getExtenssions().compteurLigne = 0;
			// increase speed every 10 completed lines
			int currentPeriodicite = this.timer.getDelay();
			if (currentPeriodicite > 50) { // make sure delay doesn't go below 50ms
				this.timer.setDelay(currentPeriodicite - 50);
			}
		}
	}
}