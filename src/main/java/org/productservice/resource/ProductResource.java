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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/product")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/{productId}",method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Get Product by Product Id", notes="Get Product by Product Id", response=Product.class)
	@ApiResponses(value= {@ApiResponse(code=200, message="OK"), @ApiResponse(code=500, message="Internal Server Error")})
	public ResponseEntity<Product> getProduct(@PathVariable("productId") String productId) {		
		Product product=productService.getProductById(productId);
		if(null==product) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(product);
	}
	
	@RequestMapping(value="/fetchAll", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> fetchAllProducts(){
		return ResponseEntity.ok(productService.getAllProducts());
	}
	
	@RequestMapping(value="/{productId}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("productId")String productId) {
		productService.addProduct(productService.getProductById(productId));
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}	
}
