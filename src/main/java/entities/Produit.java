package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Produit {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduit;
	private Double prix;
	private String name;
	
	@OneToMany(mappedBy = "produit",cascade = CascadeType.ALL)
	private List<Commander> commandes;
	
	@ManyToOne
	@JoinColumn(name = "categorie_id")
	private Categorie categorie;
	
	public Produit() {
		
	}
	
	public Produit(Integer idproduit,String name) {
		this.idProduit = idproduit;
		this.name = name;
	}
	
	
	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Commander> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commander> commandes) {
		this.commandes = commandes;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "Produit [idProduit=" + idProduit + ", prix=" + prix + ", name=" + name + ", commandes=" + commandes
				+ ", categorie=" + categorie + "]";
	}
	
	

	
	
	
	
}
