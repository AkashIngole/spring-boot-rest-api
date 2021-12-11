package com.fullstack.service;

import java.util.List;

import com.fullstack.model.Product;

public interface IProductService {

	List<Product> getProducts();
	Product getProductDetails(Long productId);
	String addProductToCollection(Long productId, String productName, Integer productPrice);
	String updateExistingProduct(Product product);
	String deleteProductById(Long id);
}
