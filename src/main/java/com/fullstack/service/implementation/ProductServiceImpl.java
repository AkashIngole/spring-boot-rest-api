package com.fullstack.service.implementation;

import java.util.*;

import org.springframework.stereotype.Service;

import com.fullstack.model.Product;
import com.fullstack.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	List<Product> productsList = new ArrayList<>();
	
	private ProductServiceImpl() {
		productsList.add(new Product(101L, "Kitchen Utensils", 3500));
		productsList.add(new Product(102L, "Electric Applicances", 11499));
		productsList.add(new Product(103L, "Mobile Phones", 35000));
		productsList.add(new Product(104L, "Wooden Furniture", 17560));
		productsList.add(new Product(105L, "Water Purifier", 17800));
	}
	
	@Override
	public List<Product> getProducts() {
		return productsList;
	}

	@Override
	public Product getProductDetails(Long productId) {
		for(Product product : productsList) {
			if(product.getProductID() == productId) {
				return product;
			}
		}
		
		return null;
	}

	@Override
	public String addProductToCollection(Long productId, String productName, Integer productPrice) {
		if(productId == null || productName == null || productPrice == null) {
			return "Invalid Product Details";
		}
		
		productsList.add(new Product(productId, productName, productPrice));
		
		return "Product added successfully! \nTotal Products = " + productsList.size();
	}

	@Override
	public String updateExistingProduct(Product product) {
		if(product == null || product.getProductID() == null || product.getProductName() == null || product.getProductPrice() == null) {
			return "Invalid Input";
		}
		for(Product existingProduct : productsList) {
			if(existingProduct.getProductID().equals(product.getProductID())) {
				existingProduct.setProductName(product.getProductName());
				existingProduct.setProductPrice(product.getProductPrice());
				return "Product updated successfully!";
			}
		}
		
		return "No valid product with given productId found!";
	}

	@Override
	public String deleteProductById(Long id) {
		Product product = getProductDetails(id);
		if(product == null) {
			return "Product Not Available!";
		}
		productsList.remove(product);
		return "Product Removed Successfully!";
	}

}
