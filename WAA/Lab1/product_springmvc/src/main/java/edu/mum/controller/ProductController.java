package edu.mum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

	@RequestMapping(method = RequestMethod.GET)
	public String getProductForm(Model model ) {
		// TODO implementation...


		model.addAttribute("product", new Product());
		model.addAttribute("categories", categoryService.getAll());
		return "ProductForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveProduct(Product product) {
		// TODO implementation...
		int categoryId = product.getCategory().getId();
		Category category = categoryService.getCategory(categoryId);
		product.setCategory(category);
		productService.save(product);
		return "ProductDetails";
	}

	@RequestMapping("/listproducts")
	public String listProducts(Model model) {
		// TODO implementation...
		model.addAttribute("products", productService.getAll());
		return "ListProducts";
	}
	@RequestMapping("/product")
	public String getProduct(@RequestParam(value = "id") String productId,Model model) {
		// TODO
		if(productId != null) {
			Product product = productService.getAll().stream().filter(x -> String.valueOf(x.getId()).equals(productId)).findFirst().get();
			if (product != null) {
				model.addAttribute("product", product);
				return "SingleProduct";
			}
		}
		return "Find";
	}

	@RequestMapping("/productfind")
	public String findProduct(Model model) {
		// TODO
		return "Find";
	}
}
