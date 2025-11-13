package produit;

public class Poisson extends Produit {
	private String date;

	public Poisson(String nom, String unite, String date) {
		super("poisson", Unite.PIECE);
		this.date = date;
	}
	
	public void decrireProduit() {
		System.out.println("Poisson pêchés " + date +"\n");
	}
}
