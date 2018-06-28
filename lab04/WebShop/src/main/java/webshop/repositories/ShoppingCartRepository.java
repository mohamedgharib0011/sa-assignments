package webshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.models.shoppingcart.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, Integer> {

}
