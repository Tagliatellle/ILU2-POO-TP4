package produit;

public enum Unite {
	GRAMME("g"),
	KILOGRAMME("kg"),
	LITRE("l"),
	CENTILITRE("cl"),
	MILLITRE("ml"),
	PIECE("piece");

	private String unite;
	
	private Unite(String unite) {
	    this.unite = unite;
	}

	@Override
	public String toString() {
		return unite;
	}
}
