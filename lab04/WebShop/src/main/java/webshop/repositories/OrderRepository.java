package webshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.models.order.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {

}
