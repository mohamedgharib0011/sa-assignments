package webshop.order.domain;

import java.util.Date;

import webshop.shared.dto.ProductDTO;
import webshop.shared.dto.ShoppingCartDTO;

/**
 * 
 * @author mbeshir
 *
 */
public class OrderFactory {

	/**
	 * create order from {@link ShoppingCartDTO}
	 * 
	 * @param shoppingCartDTO
	 * @return {@link Order}
	 */
	public static Order createOrder(ShoppingCartDTO shoppingCartDTO) {
		Order order = new Order(shoppingCartDTO.getCartNumber(), new Date(), OrderStatus.INITIATED);
		shoppingCartDTO.getCartlineList().forEach(cardLine -> {
			ProductDTO product = cardLine.getProduct();
			order.addOrderLine(new OrderLine(cardLine.getQuantity(),
					new Product(product.getProductnumber(), product.getName(), product.getPrice())));
		});
		return order;
	}
}
