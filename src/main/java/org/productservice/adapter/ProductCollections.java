package org.productservice.adapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.productservice.object.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ProductCollections {

	List<Product> productList= new ArrayList<Product>(Arrays.asList(
			new Product("1001","Pen","Master pen",300),
			new Product("1002","Pencil","Siste Pencil",50),
			new Product("1003","ball","cosco ball",200),
			new Product("1004","Laptop","HP laptop",12500)
			));
	
	public Product getProduct(String productId) {
		if(null!=productId) {
		Iterator<Product> it=productList.iterator();
		while(it.hasNext()) {
			Product product=it.next();
			if(productId.equals(product.getProductId())) {
				return product;
			}
		}
		
		}
		return null;
		
	}
	
}
