package integration.router;

import integration.model.Order;

/**
 * 
 * @author mbeshir
 *
 */
public class OrderShippingRouter {

	/**
	 * switch between shipping types based on the order amount
	 * 
	 * @param order
	 * @return
	 */
	public String route(Order order) {
		return order.getAmount() > 175 ? "fedexShippingChannel" : "dhlShippingChannel";

	}

}
