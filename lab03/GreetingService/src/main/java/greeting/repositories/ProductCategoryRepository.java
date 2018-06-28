package greeting.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import greeting.models.Product;

public interface ProductCategoryRepository extends MongoRepository<Product, Integer> {

}
