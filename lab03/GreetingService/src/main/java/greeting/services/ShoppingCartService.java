package greeting.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import greeting.models.Product;
import greeting.models.ShoppingCart;
import greeting.repositories.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository cartRepository;

	@Autowired
	ProductCategoryService productCategoryService;

	public void addToCart(Integer cartNum, Integer productnumber, Integer quantity) {
		cartRepository.findById(cartNum).ifPresent(cart -> {
			Product product = productCategoryService.getProduct(productnumber);
			cart.addToCart(product, quantity);
			cartRepository.save(cart);
		});

	}

	public ShoppingCart getCart(Integer cartNum) {
		return cartRepository.findById(cartNum).orElse(null);
	}

	public ShoppingCart addCart(Integer cartNum) {
		return cartRepository.save(new ShoppingCart(cartNum));
	}
}
