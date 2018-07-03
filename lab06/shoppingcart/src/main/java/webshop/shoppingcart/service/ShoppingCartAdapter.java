package webshop.shoppingcart.service;

import webshop.shoppingcart.domain.Product;
import webshop.shoppingcart.domain.ShoppingCart;
import webshop.shoppingcart.service.dto.CartLineDTO;
import webshop.shoppingcart.service.dto.ShoppingCartDTO;
import webshop.shoppingcart.service.dto.SimpleProductDTO;

/**
 * used for convertion between {@link ShoppingCart} and {@link ShoppingCartDTO}
 * 
 * @author mbeshir
 *
 */
public class ShoppingCartAdapter {

	/**
	 * convert from {@link ShoppingCart} to {@link ShoppingCartDTO}
	 * 
	 * @param shoppingCart
	 * @return {@link ShoppingCartDTO}
	 */
	public static ShoppingCartDTO getShoppingCartDTO(ShoppingCart shoppingCart) {
		ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
		shoppingCartDTO.setCartNumber(shoppingCart.getCartNumber());
		shoppingCart.getCartlineList().forEach(cartLine -> {
			Product product = cartLine.getProduct();
			SimpleProductDTO productDTO = new SimpleProductDTO();
			CartLineDTO cartLineDTO = new CartLineDTO();
			cartLineDTO.setProduct(productDTO);

			shoppingCartDTO.getCartlineList().add(new CartLineDTO(cartLine.getQuantity(),
					new SimpleProductDTO(product.getProductnumber(), product.getName(), product.getPrice())));
		});

		return shoppingCartDTO;

	}

}
