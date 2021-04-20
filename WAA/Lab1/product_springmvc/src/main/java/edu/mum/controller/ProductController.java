package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.domain.Category;
import edu.mum.domain.Product;
import edu.mum.service.CategoryService;
import edu.mum.service.ProductService;

@RequestMapping("/product")
@Controller
public class ProductController {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;


	public String getProductForm(   ) {
		// TODO implementation...
		return "";
	}


	public String saveProduct(Product product) {
		// TODO implementation...
		return "";
	}


	public String listProducts(Model model) {
		// TODO implementation...
		return "";
	}


	@RequestMapping("/productfind")
	public String findProduct() {
		// TODO
		return "Find";
	}
}
