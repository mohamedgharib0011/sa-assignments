package webshop.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.product.domain.Product;

/**
 * 
 * @author mbeshir
 *
 */
public interface ProductRepository extends MongoRepository<Product, String> {

}
