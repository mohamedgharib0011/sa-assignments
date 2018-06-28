package greeting.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import greeting.models.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Integer> {

}
