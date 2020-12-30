package org.productservice.service;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.productservice.object.Product;
import org.productservice.persist.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProductServiceIntegrationTest {
	
	@TestConfiguration
	static class ProductServiceContextConfig{
		@Bean
		public ProductService getProductService() {
			return new ProductService();
		}		
	}

	@Autowired
	private ProductService productService;
	@MockBean
	private ProductRepository productRepository;
	
	@Before
	public void Setup(){		
		Product p= new Product("1234", "shoes","shoes2",100);	
		Optional<Product> optional=Optional.of(p);
		List<Product> pl= new ArrayList<Product>();
		pl.add(new Product("12345","pen","my pen",120));
		pl.add(p);
		pl.add(new Product("123456","ball","my ball",120));
		Mockito.when(productRepository.findById(p.getProductId())).thenReturn(optional);	
		Mockito.when(productRepository.findAll()).thenReturn(pl);
		Mockito.when(productRepository.existsById(p.getProductId())).thenReturn(true);		
	}
	
	@Test
	public void getProductByIdTest() {
		Product p= new Product("1234", "shoes","shoes2",100);	
		Product out=productService.getProductById(p.getProductId());
		assertThat(p.getProductId().equals(out.getProductId()));
	}
	
}
