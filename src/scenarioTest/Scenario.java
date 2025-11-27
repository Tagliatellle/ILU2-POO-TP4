package scenarioTest;

import personnages.Gaulois;
import produit.IProduit;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegaulois.IVillage;

public class Scenario {

	public static void main(String[] args) {

		class Village implements IVillage {
			private IEtal[] marche;

			public Village(int nbEtal) {
				this.marche = new IEtal[nbEtal];
			}
			
			@Override
			public String toString() {
				StringBuilder msg = new StringBuilder();
				for (int i = 0; i < marche.length && marche[i]!=null ; i++) {
					msg.append(marche[i].etatEtal());
				}
				msg.append("\n");
				return msg.toString();
			}

			@Override
			public <P extends IProduit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix) {
				for (int i = 0; i < this.marche.length; i++) {
					if (this.marche[i] == null) {
						etal.installerVendeur(vendeur, produit, prix);
						this.marche[i] = etal;
						return true;
					}
				}
				return false;
			}

			@Override
			public void acheterProduit(String produit, int quantiteSouhaitee) {
				for (int i = 0 ; i<marche.length ; i++) {
					if (marche[i]!=null) {
						int quantiteDispo = marche[i].contientProduit(produit, quantiteSouhaitee);
						if (quantiteDispo>=quantiteSouhaitee) {
							marche[i].acheterProduit(quantiteSouhaitee);
							System.out.println("A l'etal n∞" + i + ", j'achËte " + quantiteSouhaitee + " et de je paie " + marche[i].getProduitsPrix(quantiteSouhaitee) + "sous.\n");
						}
						if (quantiteDispo<quantiteSouhaitee && quantiteDispo>0) {
							marche[i].acheterProduit(quantiteDispo);
							System.out.println("A l'etal n∞" + i + ", j'achËte " + quantiteDispo + " et de je paie " + marche[i].getProduitsPrix(quantiteDispo) + "sous.\n");
							if (quantiteSouhaitee-quantiteDispo>0) {
								this.acheterProduit(produit, quantiteSouhaitee-quantiteDispo);
							}
						}
					}
				}

			}
		}

		// fin
		Village village = new Village(4);
		
		Gaulois ordralfabetix = new Gaulois("Ordralfab√©tix", 9);
		Gaulois obelix = new Gaulois("Ob√©lix", 20);
		Gaulois asterix = new Gaulois("Ast√©rix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		village.acheterProduit("sanglier", 3);
		
		System.out.println(village);
//
//		System.out.println(village);
	}

}
