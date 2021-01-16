package org.productservice.resource;

import java.util.List;

import org.productservice.object.Product;
import org.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/products/{productId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {		
		Product product=productService.getProductById(productId);
		if(null==product) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	
	@RequestMapping(value="/products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> fetchAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@RequestMapping(value="/products/{productId}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("productId")String productId) {
		productService.addProduct(productService.getProductById(productId));
	}
	
	@RequestMapping(value="/products", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}	
}
