package dao;

import java.util.List;

import config.Configuration;
import entities.Categorie;

public class CategorieDAOImpl implements ICategorieDAO {

	Configuration config = new Configuration();
	
	@Override
	public List<Categorie> getCategories() {
		List<Categorie> categories = config.getEntityManager().createQuery("select c from Categorie c", Categorie.class).getResultList();
		return categories;
	}

	@Override
	public Categorie getCategorieById(Integer id) {
		Categorie cat = new Categorie();
		cat = config.getEntityManager().find(Categorie.class, id);
		return cat;
	}

	@Override
	public void addCategorie(Categorie c) {
		config.getEntityManager().getTransaction().begin();
		config.getEntityManager().persist(c);
		config.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void deleteCategorie(Integer id) {
		config.getEntityManager().getTransaction().begin();
		config.getEntityManager().remove(getCategorieById(id));
		config.getEntityManager().getTransaction().commit();
		
	}

	@Override
	public void updateCategorie(Categorie p) {
		config.getEntityManager().getTransaction().begin();
		config.getEntityManager().merge(p);
		config.getEntityManager().getTransaction().commit();
	}

}
