package org.productservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.productservice.object.Product;
import org.productservice.persist.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	private List<Product> products=new ArrayList<Product>();
	
	public List<Product> getAllProducts(){
		productRepository.findAll().forEach(p->products.add(p));
		return products;
	}
	
	public Product getProductById(String productId) {
		if(!products.isEmpty()) {
		 Iterator<Product> it=products.iterator();
		 while(it.hasNext()) {
			 Product p=it.next();
			 if(productId.equalsIgnoreCase(p.getProductId()))
				 return p;
		 }
		}else {			
				if(productRepository.existsById(productId)) {
				return productRepository.findById(productId).get();		
				}else {
					return null;
				}
		}
		return null;
	}
	
	public void deleteProduct(Product product) {
		productRepository.delete(product);
	}
	
	public String addProduct(Product product) {
		productRepository.save(product);
		return product.getProductId();
	}
	
	public void addProducts(List<Product> prods) {
		productRepository.saveAll(prods);
	}
	
	public void updateProduct(Product product) {
		productRepository.save(product);
	}	
}
