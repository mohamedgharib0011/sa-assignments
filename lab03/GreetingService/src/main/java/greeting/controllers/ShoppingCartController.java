package greeting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import greeting.models.ShoppingCart;
import greeting.services.ShoppingCartService;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

	@Autowired
	ShoppingCartService cartService;

	@PutMapping("/newproduct/{productnumber}/{quantity}/{cartNum}")
	public ResponseEntity<Void> addToCart(@PathVariable() Integer cartNum, @PathVariable Integer productnumber,
			@PathVariable Integer quantity) {
		cartService.addToCart(cartNum, productnumber, quantity);
		return new ResponseEntity<Void>(HttpStatus.OK);

	}

	@PostMapping("/{cartNum}")
	public ResponseEntity<ShoppingCart> addCart(@PathVariable Integer cartNum) {
		return new ResponseEntity<ShoppingCart>(cartService.addCart(cartNum), HttpStatus.OK);

	}

	@GetMapping("/{cartNum}")
	public ResponseEntity<ShoppingCart> getCart(@PathVariable Integer cartNum) {
		return new ResponseEntity<ShoppingCart>(cartService.getCart(cartNum), HttpStatus.OK);

	}

}
