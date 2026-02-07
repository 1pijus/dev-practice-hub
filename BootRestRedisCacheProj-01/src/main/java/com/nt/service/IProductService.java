package com.nt.service;

import java.util.List;

import com.nt.entity.Product;

public interface IProductService {

	public Product findProductById(Integer pid);
	public String registerProduct(Product product);
	public List<Product>showAllProduct();
	public String deleteProductById(Integer pid);
	
}
