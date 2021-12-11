package com.fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fullstack.model.Product;
import com.fullstack.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private IProductService iProductService;
	
	@GetMapping("")
	public List<Product> getAllProducts() {
		return iProductService.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductDetails(@PathVariable("id") Long id) {
		return iProductService.getProductDetails(id);
	}
	
	@PostMapping("/addProduct") 
	public String addProduct(@RequestParam(value = "productId") Long productId, 
			@RequestParam(value = "productName") String productName, @RequestParam(value = "productPrice") Integer productPrice) {
		return iProductService.addProductToCollection(productId, productName, productPrice);
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Product product) {
		return iProductService.updateExistingProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") Long id) {
		return iProductService.deleteProductById(id);
	}

}
