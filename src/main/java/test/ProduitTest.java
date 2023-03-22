package test;


import java.util.List;
import java.util.Scanner;

import dao.CategorieDAOImpl;
import dao.ICategorieDAO;
import dao.IProduitDAO;
import dao.ProduitDAOImpl;
import entities.Categorie;
import entities.Produit;

public class ProduitTest {
	
	public static void afficherProduitTest() {
		IProduitDAO produitDao = new ProduitDAOImpl();
		List<Produit> produits = produitDao.findAllProduct();
		produitDao.afficherProduit(produits);
	}
	
	public static void addProduitTest() {
		IProduitDAO produitDao = new ProduitDAOImpl();
		ICategorieDAO categorieDao = new CategorieDAOImpl();
		try (Scanner scan = new Scanner(System.in);){
			Produit p = new Produit();
			System.out.print("Entrer le nom du Produit");
			String nameP = scan.nextLine();
			p.setName(nameP);
			System.out.print("Entrer le prix du Produit");
			Double prix = scan.nextDouble();
			p.setPrix(prix);
			System.out.println("Veuillez choisir la categorie du produit : \n" 
					+ "1 - Phones \n2 - Laptops");
			Categorie c = new Categorie();
			Integer idCat = scan.nextInt();
			c = categorieDao.getCategorieById(idCat);
			p.setCategorie(c);
			produitDao.addProduct(p);
		}
	}
	
	public static void deleteProduct() {
		IProduitDAO produitDao = new ProduitDAOImpl();
		try (Scanner scan = new Scanner(System.in);){
			List<Produit> produits = produitDao.findAllProduct();
			produitDao.afficherProduit(produits);
			System.out.print("\n\nEntrer l'id du Produit que vous voulez supprimer.");
			Integer id = scan.nextInt();
			produitDao.deleteProduct(id);
		}
	}

 
	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in);){
			
			System.out.println("****************************Menu :***********************************");
			System.out.println("1 - Afficher tous les produits.");
			System.out.println("2 - Ajouter un produit.");
			System.out.println("3 - Supprimer un produit.");
				
			boolean res = true;
			while(res) {
				Integer choice = Integer.parseInt(scan.nextLine());
				switch (choice) {
				case 1:
					afficherProduitTest();
					System.out.println("*****************************************************************");
					System.out.println("2 - Ajouter un produit.");
					System.out.println("3 - Supprimer un produit.");
					break;
				case 2 :
					addProduitTest();
					System.out.println("*****************************************************************");
					System.out.println("1 - Afficher tous les produits.");
					System.out.println("3 - Supprimer un produit.");
					break;
				case 3 :
					deleteProduct();
					System.out.println("*****************************************************************");
					System.out.println("1 - Afficher tous les produits.");
					System.out.println("2 - Ajouter un produit.");
					break;
				case 0:
					res = false;
					System.out.println("exit");
					break;
				}
			}
			
			
		}
	}

}
