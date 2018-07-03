package integration.filter;

import integration.model.Order;

/**
 * used for validating the order amount
 * 
 * @author mbeshir
 *
 */
public class OrderAmountFilter {

	public boolean filter(Order order) {
		return order.getAmount() >= 1;
	}

}
