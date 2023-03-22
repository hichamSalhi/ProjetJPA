package test;

import java.util.List;

import dao.CategorieDAOImpl;
import dao.ICategorieDAO;
import entities.Categorie;

public class CategorieTest {

	public static void afficherCategorieTest() {
		ICategorieDAO iCategorieDao;
		iCategorieDao = new CategorieDAOImpl();
		
		List<Categorie> cats = iCategorieDao.getCategories();
		if(cats != null) {
			for (Categorie categorie : cats) {
				System.out.println(categorie);
			}
		}
	}
	
	public static void afficherCategorieParId(Integer id) {
		ICategorieDAO iCategorieDao = new CategorieDAOImpl();
		Categorie cat = iCategorieDao.getCategorieById(id);
		System.out.println(cat);
	}
	
	public static void main(String[] args) {
		afficherCategorieTest();
	}

}
