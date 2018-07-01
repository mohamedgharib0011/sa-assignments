package webshop.shoppingcart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.shoppingcart.domain.ShoppingCart;

public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

}
