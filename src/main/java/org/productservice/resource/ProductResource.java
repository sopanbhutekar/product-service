package org.productservice.resource;


import org.productservice.adapter.ProductCollections;
import org.productservice.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	@Autowired
	private ProductCollections productCollections;
	
	@RequestMapping("/{productId}")
	public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {		
		Product product=productCollections.getProduct(productId);
		if(null==product) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(product);
	}
	
	
}
