package integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import integration.gateway.OrderGateway;
import integration.model.Order;

@RestController
public class Controller {
	@Autowired
	private OrderGateway gateway;

	@PostMapping("/orderprocess")
	public ResponseEntity<Void> placeOrder(@RequestBody Order order) {

		Message<Order> helloMessage = MessageBuilder.withPayload(order).build();
		gateway.handleRequest(helloMessage);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
