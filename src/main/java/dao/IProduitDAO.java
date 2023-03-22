package dao;
import java.util.List;

import entities.Produit;

public interface IProduitDAO {
	public List<Produit> findProduitParMC(String mc);
	public List<Produit> findAllProduct();
	public void addProduct(Produit p);
	public Produit findProduct(Integer id);
	public void deleteProduct(Integer id);
	public void afficherProduit(List<Produit> p);
	public void updateProduct(Produit p);
}

