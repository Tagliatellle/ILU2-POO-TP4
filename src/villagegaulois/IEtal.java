package villagegaulois;

import personnages.Gaulois;
import produit.Produit;

public interface IEtal {
	Gaulois getVendeur();
	int getProduitsPrix(int quantite);
	int contientProduit(String produit, int quantiteSouhaitee);
	int acheterProduit(int quantiteSouhaitee);
	String etatEtal();
}