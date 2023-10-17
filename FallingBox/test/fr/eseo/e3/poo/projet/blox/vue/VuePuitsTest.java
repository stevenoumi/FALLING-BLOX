package fr.eseo.e3.poo.projet.blox.vue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.eseo.e3.poo.projet.blox.modele.Puits;

public class VuePuitsTest {

    private VuePuits vuePuits;
    private Puits puits;
    
    @Test
    public void testGetPuits() {
    	puits = new Puits(10,20);
        vuePuits = new VuePuits(puits);
        assertEquals(puits.toString() , vuePuits.getPuits().toString());
    }
    
    @Test
    public void testGetTaille() {
    	puits = new Puits();
        vuePuits = new VuePuits(puits);
        assertEquals(VuePuits.TAILLE_PAR_DEFAUT, vuePuits.getTaille());
    }
    
    @Test
    public void testSetPuits() {
    	puits = new Puits();
        vuePuits = new VuePuits(puits);
        Puits puits2 = new Puits();
        vuePuits.setPuits(puits2);
        assertEquals(puits2, vuePuits.getPuits());
    }
    
    @Test
    public void testSetTaille() {
    	puits = new Puits();
        vuePuits = new VuePuits(puits);
        vuePuits.setTaille(30);
        assertEquals(30, vuePuits.getTaille());
    }
    
}
