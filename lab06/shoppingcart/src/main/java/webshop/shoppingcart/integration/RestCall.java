package webshop.shoppingcart.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import webshop.shoppingcart.service.dto.ShoppingCartDTO;

@Service
public class RestCall {

	@Autowired
	private RestOperations retTemplate;

	public void createOrder(ShoppingCartDTO shoppingCartDTO) {
		retTemplate.postForObject("http://localhost:8082/order",  new HttpEntity<>(shoppingCartDTO), Void.class);
	}

}
