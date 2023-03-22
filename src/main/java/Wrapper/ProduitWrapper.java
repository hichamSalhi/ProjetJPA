package Wrapper;

public class ProduitWrapper {
	
	private String name;
	private Double prix;
	private String nameCat;
	
	public ProduitWrapper (String name,Double prix,String nameCat) {
		this.name = name;
		this.prix = prix;
		this.nameCat = nameCat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getNameCat() {
		return nameCat;
	}

	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}
	
	
}
