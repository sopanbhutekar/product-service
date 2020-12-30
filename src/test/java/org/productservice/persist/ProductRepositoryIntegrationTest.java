package org.productservice.persist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.productservice.object.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryIntegrationTest {
	
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private ProductRepository productRepository;
	
	@Test
	public void findById_returnProduct() {
		
		Product product=new Product("1234", "shoes", "shoes for me", 120);
		
		entityManager.persist(product);
		entityManager.flush();
		
		Product output=productRepository.findById(product.getProductId()).get();
		
		assertThat(product.getProductId().equals(output.getProductId()));
	}
	
	@Test
	public void deleteProductTest() {
		
		Product product=new Product("1234", "shoes", "shoes for me", 120);
		Product product2=new Product("12345", "shoes", "shoes for me", 130);
		
		entityManager.persist(product);
		entityManager.persist(product2);		
		entityManager.flush();
		
		productRepository.delete(product);
		assertThat(!productRepository.existsById(product.getProductId()));
	}	
	
	
}
