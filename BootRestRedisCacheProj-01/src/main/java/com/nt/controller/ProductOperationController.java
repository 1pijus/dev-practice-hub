package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Product;
import com.nt.service.IProductService;

@RestController
public class ProductOperationController {
    @Autowired
	private IProductService prodService;
	@PostMapping("/register")
    public ResponseEntity<String> saveProduct(@RequestBody Product product)
    {
    	String msg=prodService.registerProduct(product);
    	return new ResponseEntity<String>(msg,HttpStatus.CREATED);
    }
    
    @GetMapping("/find/{pid}")
    public ResponseEntity<Product> showProductById(@PathVariable Integer pid)
    {
    	Product product =prodService.findProductById(pid);
    	return new ResponseEntity<Product>(product,HttpStatus.FOUND);
    }
    
    @GetMapping("/findAll")
    public ResponseEntity<List<Product>> showAllProduct()
    {
    	  List<Product> list=prodService.showAllProduct();
    	  
    	  return new ResponseEntity<List<Product>>(list,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deletProductById(@PathVariable Integer id)
    {
    	   String msg=prodService.deleteProductById(id);
    	   
    	   return new ResponseEntity<String>(msg,HttpStatus.OK);
    }
    
    
    
    
	
	
}
