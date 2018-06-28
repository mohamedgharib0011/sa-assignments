package webshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.models.product.Product;

public interface ProductCategoryRepository extends MongoRepository<Product, Integer> {

}
