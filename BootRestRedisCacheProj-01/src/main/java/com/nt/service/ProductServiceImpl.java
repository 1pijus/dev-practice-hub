package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.nt.entity.Product;
import com.nt.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
    private IProductRepository productRepo;
	
	
	@Override
	@CachePut(value = "prod",key="#product.pid")
	public String registerProduct(Product product) {
	   Product savedProduct=productRepo.save(product);
		
		return "The product is saved with id VAlue:"+savedProduct.getPid();
	}
	
	@Override
	@Cacheable(value = "prod",key="#pid")
	public Product findProductById(Integer pid)
	{
      return productRepo.findById(pid).orElseThrow(()-> new IllegalArgumentException("Invalid Pid"));
	}
	
	@Override
	@Cacheable(value = "prods", key="'ALL'")
	public List<Product> showAllProduct() {
       List<Product> listProduct=productRepo.findAll();
		return listProduct;
	}
	
	@Override
	@CacheEvict(value = {"prod","prods"},allEntries=true)
	public String deleteProductById(Integer pid) {
		Optional<Product>opt=productRepo.findById(pid);
		if(opt.isPresent())
		{
			productRepo.deleteById(pid);
			
			return pid+" Product deleted successfully";
		}
		else
			return "!!!Hello product is not found for deletion";
		  
	}
	
	public void  sum()
	{

		System.out.println("ProductServiceImpl.sum() by Asish changed 2nd time");
		System.out.println("ProductServiceImpl.sum()");
	}
	
	public void practiceGit() {
		System.out.println("ProductServiceImpl.practiceGit()-------------------------------->");
		System.out.println("ProductServiceImpl.practiceGit()");
	}
	
	

	
	
	

}
