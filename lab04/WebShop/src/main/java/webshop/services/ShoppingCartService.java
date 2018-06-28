package webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.models.product.Product;
import webshop.models.shoppingcart.ShoppingCart;
import webshop.repositories.ShoppingCartRepository;

		
@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository cartRepository;

	@Autowired
	ProductCategoryService productCategoryService;
	
	@Autowired
	OrderService orderService;

	public void addToCart(Integer cartNum, Integer productnumber, Integer quantity) {
		cartRepository.findById(cartNum).ifPresent(cart -> {
			cart.addToCart(productnumber, quantity);
			cartRepository.save(cart);
		});

	}

	public ShoppingCart getCart(Integer cartNum) {
		return cartRepository.findById(cartNum).orElse(null);
	}

	public ShoppingCart addCart(Integer cartNum) {
		return cartRepository.save(new ShoppingCart(cartNum));
	}
	
	
	public void checkout(Integer cartNum) {
		orderService.createOrder(cartNum, getCart(cartNum));
	}
}
