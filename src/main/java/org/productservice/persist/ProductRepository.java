package org.productservice.persist;

import org.productservice.object.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, String>{
}
