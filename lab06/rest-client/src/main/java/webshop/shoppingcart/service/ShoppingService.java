package webshop.shoppingcart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import webshop.order.service.OrderService;
import webshop.product.service.ProductService;
import webshop.shared.dto.CartLineDTO;
import webshop.shared.dto.ProductDTO;
import webshop.shared.dto.ProductWithStockDTO;
import webshop.shared.dto.ShoppingCartDTO;
import webshop.shoppingcart.domain.Product;
import webshop.shoppingcart.domain.ShoppingCart;
import webshop.shoppingcart.repository.ShoppingCartRepository;
import webshop.shoppingcart.service.event.CheckoutEvent;
import webshop.shoppingcart.service.event.ProductUnderStockEvent;

@Service
public class ShoppingService {

	@Autowired
	ProductService productService;

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Autowired
	OrderService orderService;

	@Autowired
	ApplicationEventPublisher eventPublisher;

	/**
	 * add product to the shopping cart (add new if not exist), if the amount not
	 * available, a product under-stock event will be fired, otherwise the product will be added normally
	 * 
	 * @param cartNumber
	 * @param productNumber
	 * @param quantity
	 */
	public void addToCart(String cartNumber, String productNumber, int quantity) {
		ProductWithStockDTO productDTO = productService.getProductWithStock(productNumber);

		// create a shopping product from the productDTO
		Product product = new Product(productDTO.getProductnumber(), productDTO.getName(), productDTO.getPrice());
		Optional<ShoppingCart> cartOptional = shoppingCartRepository.findById(cartNumber);

		// add to existing shopping card or add new one with the same card number
		ShoppingCart cart = cartOptional.isPresent() ? cartOptional.get() : new ShoppingCart(cartNumber);

		// check if a the quantity available
		if (quantity >= productDTO.getStockAmount()) {
			eventPublisher.publishEvent(new ProductUnderStockEvent(productNumber));
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
		return opCart.isPresent() ? constructShoppingCartDTO(opCart.get()) : null;
	}

	/**
	 * create order from the shopping cart with the passed id then publish an event
	 * 
	 * @param cartNumber
	 */
	public void checkout(String cartNumber) {
		shoppingCartRepository.findById(cartNumber).ifPresent(cart -> {
			orderService.createOrder(constructShoppingCartDTO(cart));
		});
		eventPublisher.publishEvent(new CheckoutEvent("checkout event for shopping card number " + cartNumber));
	}

	/**
	 * constructing {@link ShoppingCartDTO} from {@link ShoppingCart}
	 * 
	 * @param shoppingCart
	 * @return {@link ShoppingCartDTO}
	 */
	private ShoppingCartDTO constructShoppingCartDTO(ShoppingCart shoppingCart) {
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		shoppingCartDTO.setCartNumber(shoppingCart.getCartNumber());
		shoppingCart.getCartlineList().forEach(cartLine -> {
			Product product = cartLine.getProduct();
			ProductDTO productDTO = new ProductDTO();
			CartLineDTO cartLineDTO = new CartLineDTO();
			cartLineDTO.setProduct(productDTO);

			shoppingCartDTO.getCartlineList().add(new CartLineDTO(cartLine.getQuantity(),
					new ProductDTO(product.getProductnumber(), product.getName(), product.getPrice())));
		});

		return shoppingCartDTO;

	}
}
