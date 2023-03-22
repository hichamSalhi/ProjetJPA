package web;

import java.io.IOException;
import java.util.List;

import dao.CategorieDAOImpl;
import dao.ICategorieDAO;
import dao.IProduitDAO;
import dao.ProduitDAOImpl;
import entities.Categorie;
import entities.Produit;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "cs",urlPatterns = {"/Products","/AddProducts","/deleteProduit","/UpdateProducts","/categories","/deleteCategorie",
		"/AddCategory","/UpdateCategory"})
public class ControlleurProduitServlet extends HttpServlet{
	private IProduitDAO iProduitDao ;
	private ICategorieDAO iCategorieDao;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		iProduitDao = new ProduitDAOImpl();
		iCategorieDao = new CategorieDAOImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String path = req.getServletPath();
		  
		  
			if(path.equals("/AddProducts")) {
			 
			  List<Categorie> categories = iCategorieDao.getCategories(); 
			  req.setAttribute("categories", categories);
			  req.getRequestDispatcher("AddProducts.jsp").forward(req, resp); 
			  
			  }else if(path.equals("/Products")) { 
				  
			  List<Produit> produits = iProduitDao.findAllProduct(); 
			  req.setAttribute("produits", produits);
			  req.getRequestDispatcher("Products.jsp").forward(req, resp); 
			  
			  }else if(path.equals("/deleteProduit")) {
				  iProduitDao.deleteProduct(Integer.parseInt(req.getParameter("idProduit")));
				  resp.sendRedirect("Products");
				  
			  }else if(path.equals("/UpdateProducts")) {
				  
				  Produit p = iProduitDao.findProduct(Integer.parseInt(req.getParameter("idProduit")));
				  req.setAttribute("idProduit", p.getIdProduit());
				  req.setAttribute("name", p.getName());
				  req.setAttribute("price", p.getPrix());
				  
				  List<Categorie> categories = iCategorieDao.getCategories(); 
				  req.setAttribute("categories", categories);
				  
				  req.setAttribute("category", p.getCategorie());
				  req.getRequestDispatcher("UpdateProducts.jsp").forward(req, resp); 
				  
			  }else if(path.equals("/categories")) {
				  
						List<Categorie> categories = iCategorieDao.getCategories();
						req.setAttribute("categories", categories);
						req.getRequestDispatcher("Categories.jsp").forward(req, resp);
			  }else if(path.equals("/deleteCategorie")) {
				  		iCategorieDao.deleteCategorie(Integer.parseInt(req.getParameter("idCategorie")));
				  		req.getRequestDispatcher("/categories").forward(req, resp);
			  }else if(path.equals("/AddCategory")) {
				  req.getRequestDispatcher("AddCategory.jsp").forward(req, resp);
				  
			  }else if(path.equals("/UpdateCategory")) {
				  Categorie c = iCategorieDao.getCategorieById(Integer.parseInt(req.getParameter("idCategory")));
				  req.setAttribute("idCategory", c.getIdCategorie());
				  req.setAttribute("name", c.getNameCat());

				  req.getRequestDispatcher("UpdateCategory.jsp").forward(req, resp); 
			  }
	}
			  
			
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		if(path.equals("/AddProducts")) {
		
		  String name = req.getParameter("name");
		  Double price = Double.parseDouble(req.getParameter("price"));
		  Integer category = Integer.parseInt(req.getParameter("category"));
		  
		  Produit p = new Produit();
		  p.setName(name); p.setPrix(price); p.setCategorie(iCategorieDao.getCategorieById(category));
		  iProduitDao.addProduct(p);
		  resp.sendRedirect("Products"); 
		  
		  }else if(path.equals("/UpdateProducts")) {
			  
			  	
				Produit p = iProduitDao.findProduct(Integer.parseInt(req.getParameter("idProduit")));
					
				String name = req.getParameter("name");
				Double price = Double.parseDouble(req.getParameter("price"));
				Integer category = Integer.parseInt(req.getParameter("category"));
				
				p.setName(name);
				p.setPrix(price); 
				p.setCategorie(iCategorieDao.getCategorieById(category));
				
				iProduitDao.updateProduct(p);
				
				resp.sendRedirect("Products");
				
		  }else if(path.equals("/AddCategory")) {
			  String name = req.getParameter("name");
		
			  Categorie c = new Categorie();
			  c.setNameCat(name);
			  iCategorieDao.addCategorie(c);
			  resp.sendRedirect("categories");
			  
		  }else if(path.equals("/UpdateCategory")) {
			  
			  Categorie c = iCategorieDao.getCategorieById(Integer.parseInt(req.getParameter("idCategory")));
			  String name = req.getParameter("name");
			  c.setNameCat(name);
			  resp.sendRedirect("categories");
		  }
	}
			
}
