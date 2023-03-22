package dao;

import java.util.List;

import config.Configuration;
import entities.Produit;

public class ProduitDAOImpl implements IProduitDAO{

	Configuration config = new Configuration();
	
	@Override
	public List<Produit> findProduitParMC(String mc) {
		return null; 
	}

	@Override
	public List<Produit> findAllProduct() {
		List<Produit> prods ;
		prods = config.getEntityManager().createQuery("select p from Produit p", Produit.class).getResultList();
		return prods;
	}

	@Override
	public void addProduct(Produit p) {
		config.getEntityManager().getTransaction().begin();
		config.getEntityManager().persist(p);
		config.getEntityManager().getTransaction().commit();
	}

	@Override
	public Produit findProduct(Integer id) {
		Produit p = new Produit();
		p = config.getEntityManager().find(Produit.class, id);
		return p;
	}

	@Override
	public void deleteProduct(Integer id) {
		config.getEntityManager().getTransaction().begin();
		config.getEntityManager().remove(findProduct(id));
		config.getEntityManager().getTransaction().commit();
	}

	@Override
	public void afficherProduit(List<Produit> p) {
		for (Produit produit : p) {
			System.out.println("Id :"+produit.getIdProduit() +" Nom du Produit :" + produit.getName());
		}
	}

	@Override
	public void updateProduct(Produit p) {
		config.getEntityManager().getTransaction().begin();
		config.getEntityManager().merge(p);
		config.getEntityManager().getTransaction().commit();
	}

}
