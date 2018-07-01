package webshop.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.shared.dto.ShoppingCartDTO;
import webshop.shoppingcart.service.ShoppingService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;

	@PutMapping(value = "/{cartId}/{productnumber}/{quantity}")
	public ResponseEntity<?> addToCart(@PathVariable String cartId, @PathVariable String productnumber,
			@PathVariable int quantity) {
		shoppingService.addToCart(cartId, productnumber, quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{cartId}")
	public ResponseEntity<?> getCart(@PathVariable String cartId) {
		return new ResponseEntity<ShoppingCartDTO>(shoppingService.getCart(cartId), HttpStatus.OK);
	}

	@PutMapping("/checkout/{cartId}")
	public ResponseEntity<?> checkoutCart(@PathVariable String cartId) {
		shoppingService.checkout(cartId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
