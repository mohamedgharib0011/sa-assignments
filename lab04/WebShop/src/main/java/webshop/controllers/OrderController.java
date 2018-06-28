package webshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.models.order.Order;
import webshop.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/{orderId}")
	public ResponseEntity<Order> getProduct(@PathVariable Integer orderId) {
		return new ResponseEntity<Order>(orderService.getOrder(orderId), HttpStatus.OK);
	}

}
