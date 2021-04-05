package mvcDemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import mvcDemo.dao.ProductDao;
import mvcDemo.model.Product;

@Controller
public class MainController 
{
	@Autowired
	private ProductDao dao;
	
	@RequestMapping("/")
	public String home(Model m)
	{
		List<Product> products = dao.getProducts();
		m.addAttribute("products",products);
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addProduct(Model m)
	{
		m.addAttribute("title","Add Product");
		return "add-product_form";
	}
	
	//handle add product form
	@RequestMapping(value="/handle-product", method=RequestMethod.POST)
	public RedirectView handleProduct(@ModelAttribute Product product, HttpServletRequest request)
	{
		dao.createProduct(product);
		RedirectView redirectView = new RedirectView(request.getContextPath() + "/");
		return redirectView;
	}
}
