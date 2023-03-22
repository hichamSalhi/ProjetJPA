package dao;

import java.util.List;

import entities.Categorie;

public interface ICategorieDAO {
	public List<Categorie> getCategories();
	public Categorie getCategorieById(Integer id);
	public void addCategorie(Categorie c);
	public void deleteCategorie(Integer id);
	public void updateCategorie(Categorie p);
}
