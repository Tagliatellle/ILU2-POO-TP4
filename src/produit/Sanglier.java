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

	public void decrireProduit() {
		System.out.println("Sanglier de " + this.poid + " kg chassé par " + chasseur.getNom());
	}

}
