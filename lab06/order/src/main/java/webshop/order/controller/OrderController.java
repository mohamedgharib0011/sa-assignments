package webshop.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.order.service.OrderService;
import webshop.order.service.dto.AddressDTO;
import webshop.order.service.dto.CreditCardDTO;
import webshop.order.service.dto.OrderDTO;
import webshop.order.service.dto.ShippingOptionDTO;
import webshop.order.service.dto.ShoppingCartDTO;

/**
 * 
 * @author mbeshir
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("")
	public ResponseEntity<?> createOrder(@RequestBody ShoppingCartDTO shoppingCartDTO) {
		orderService.createOrder(shoppingCartDTO);
		return new ResponseEntity<Void>( HttpStatus.OK);
	}

	@GetMapping("/{orderNumber}")
	public ResponseEntity<?> getOrder(@PathVariable String orderNumber) {
		return new ResponseEntity<OrderDTO>(orderService.getOrder(orderNumber), HttpStatus.OK);
	}

	@PutMapping("/{orderNumber}/customer/{customerNumber}")
	public ResponseEntity<?> setOrderCustomer(@PathVariable String orderNumber, @PathVariable String customerNumber) {
		orderService.setOrderCustomer(orderNumber, customerNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{orderNumber}/creditcard")
	public ResponseEntity<?> setOrderCreditCard(@PathVariable String orderNumber,
			@RequestBody CreditCardDTO creditCardDTO) {
		orderService.setOrderCreditCard(orderNumber, creditCardDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{orderNumber}/shippingoption")
	public ResponseEntity<?> setOrderShippingOption(@PathVariable String orderNumber,
			@RequestBody ShippingOptionDTO shippingOptionDTO) {
		orderService.setOrderShippingOption(orderNumber, shippingOptionDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{orderNumber}/shippingAddress")
	public ResponseEntity<?> setOrderShippingAddress(@PathVariable String orderNumber,
			@RequestBody AddressDTO addressDTO) {
		orderService.setOrderShippingAddress(orderNumber, addressDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{orderNumber}/billingAddress")
	public ResponseEntity<?> setOrderbillingAddress(@PathVariable String orderNumber,
			@RequestBody AddressDTO addressDTO) {
		orderService.setOrderBillingAddress(orderNumber, addressDTO);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/{orderNumber}/confirm")
	public ResponseEntity<?> confirmOrder(@PathVariable String orderNumber) {
		orderService.confirmOrder(orderNumber);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
