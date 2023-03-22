package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	
	@Id @GeneratedValue
	private Integer idCategorie;
	private String nameCat;
	
	
	@OneToMany(mappedBy = "categorie")
	List<Produit> produits;


	public Integer getIdCategorie() {
		return idCategorie;
	}


	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}


	public String getNameCat() {
		return nameCat;
	}


	public void setNameCat(String nameCat) {
		this.nameCat = nameCat;
	}


	public List<Produit> getProduits() {
		return produits;
	}


	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}


	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", nameCat=" + nameCat + ", produits=" + produits + "]";
	}
	
	
	
	
}
