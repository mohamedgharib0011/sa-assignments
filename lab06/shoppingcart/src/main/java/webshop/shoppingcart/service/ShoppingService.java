package webshop.shoppingcart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import webshop.shoppingcart.domain.Product;
import webshop.shoppingcart.domain.ShoppingCart;
import webshop.shoppingcart.integration.JMSIntegration;
import webshop.shoppingcart.integration.RestCall;
import webshop.shoppingcart.repository.ShoppingCartRepository;
import webshop.shoppingcart.service.dto.CartLineDTO;
import webshop.shoppingcart.service.dto.ShoppingCartDTO;
import webshop.shoppingcart.service.dto.SimpleProductDTO;
import webshop.shoppingcart.service.event.CheckoutEvent;
import webshop.shoppingcart.service.event.ProductUnderStockEvent;

@Service
public class ShoppingService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	
	@Autowired
	JMSIntegration jmsSender;
	
	@Autowired
	RestCall restCall;

	/**
	 * add product to the shopping cart (add new if not exist), if the amount not
	 * available, a product under-stock event will be fired, otherwise the product
	 * will be added normally
	 * 
	 * @param cartNumber
	 * @param productNumber
	 * @param quantity
	 */
	public void addToCart(String cartNumber,Integer quantity, SimpleProductDTO simpleProductDTO) {

		// create a shopping product from the productDTO
		Product product = new Product(simpleProductDTO.getProductnumber(), simpleProductDTO.getName(),
				simpleProductDTO.getPrice());
		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartNumber);

		// add to existing shopping card or add new one with the same card number
		ShoppingCart cart = cartOptional.isPresent() ? cartOptional.get() : new ShoppingCart(cartNumber);

		// check if a the quantity available
		if (quantity >= simpleProductDTO.getStockAmount()) {
			eventPublisher.publishEvent(new ProductUnderStockEvent(simpleProductDTO.getProductnumber()));
		} else {
			cart.addToCart(product, quantity);
		}

		shoppingCartRepository.save(cart);
	}

	/**
	 * 
	 * @param cartId
	 * @return {@link ShoppingCartDTO}
	 */
	public ShoppingCartDTO getCart(String cartId) {
		Optional<ShoppingCart> opCart = shoppingCartRepository.findById(cartId);
		return opCart.isPresent() ? ShoppingCartAdapter.getShoppingCartDTO(opCart.get()) : null;
	}

	/**
	 * create order from the shopping cart with the passed id then publish an event
	 * 
	 * @param cartNumber
	 */
	public void checkout(String cartNumber) {
		shoppingCartRepository.findById(cartNumber).ifPresent(cart -> {
			restCall.createOrder(ShoppingCartAdapter.getShoppingCartDTO(cart));
		});
		eventPublisher.publishEvent(new CheckoutEvent("checkout event for shopping card number " + cartNumber));
	}

}
