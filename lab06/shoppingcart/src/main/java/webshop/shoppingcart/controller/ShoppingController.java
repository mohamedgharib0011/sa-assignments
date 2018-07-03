package webshop.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.shoppingcart.service.ShoppingService;
import webshop.shoppingcart.service.dto.ShoppingCartDTO;
import webshop.shoppingcart.service.dto.SimpleProductDTO;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingController {
	@Autowired
	ShoppingService shoppingService;

	@PutMapping(value = "/{cartId}/{quantity}")
	public ResponseEntity<?> addToCart(@PathVariable String cartId,@PathVariable Integer quantity,@RequestBody SimpleProductDTO simpleProductDTO) {
		shoppingService.addToCart(cartId,quantity, simpleProductDTO);
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
