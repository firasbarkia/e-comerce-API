package com.example.project.service.impl;

import java.util.List; 

import org.springframework.stereotype.Service;

import com.example.project.exception.RessourceNotFoundException;
import com.example.project.model.Product;
import com.example.project.repository.ProductRepository;
import com.example.project.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
//2types of dependency injection
	//setter based dependency injection
	//constructor based dependency injection
	private ProductRepository productRepository;
	
	 public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}
	@Override
	public Product getProductById(long id) {
//		Optional<Product> product = productRepository.findById(id);
//		if(product.isPresent()) {
//			return product.get();
//		}else {
//			throw new ResourceNotFoundException("Product", "Id", id);
//		}
		return productRepository.findById(id).orElseThrow(() -> 
						new RessourceNotFoundException("Product", "Id", id));
		
	}

	@Override
	public Product updateProduct(Product product, long id) {
		
		// we need to check whether product with given id  exist in DB or not
		Product existingProduct = productRepository.findById(id).orElseThrow(
				() -> new RessourceNotFoundException("Employee", "Id", id)); 
		
		existingProduct.setProductName(product.getProductName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setCategory(product.getCategory());
		
		// save existing product to DB
		productRepository.save(existingProduct);
		return existingProduct;
	}

	@Override
	public void deleteProduct(long id) {
		
		// check whether a product exist in a DB or not
		productRepository.findById(id).orElseThrow(() -> 	new RessourceNotFoundException("Product", "Id", id));
		productRepository.deleteById(id);
	}
	




}
