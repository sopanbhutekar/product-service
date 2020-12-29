package org.productservice.adapter;

import org.productservice.object.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, String>{

}
