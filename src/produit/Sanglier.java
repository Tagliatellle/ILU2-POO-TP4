package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poid;
	private Gaulois chasseur;

	public Sanglier(int poid, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poid = poid;
		this.chasseur = chasseur;
	}

	public String decrireProduit() {
		StringBuilder message = new StringBuilder("Sanglier de " + this.poid + " kg chassé par " + chasseur.getNom());
		return message.toString();
	}
	
	public int calculerPrix(int prix) {
		return prix*this.poid/1000;
	}

}
