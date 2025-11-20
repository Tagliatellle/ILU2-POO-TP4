package produit;

public interface IProduit {

	String getNom();

	String decrireProduit();

//	int calculerPrix(int prix);
    
	public default int calculerPrix(int prix) {
		return prix;
	}
}