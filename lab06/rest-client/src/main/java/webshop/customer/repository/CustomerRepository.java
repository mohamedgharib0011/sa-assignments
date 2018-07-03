package webshop.customer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import webshop.customer.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

}
