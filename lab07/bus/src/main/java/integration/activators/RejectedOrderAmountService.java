package integration.activators;

import integration.model.Order;

/** 
 * catching orders with invalid amount
 * @author mbeshir
 *
 */
public class RejectedOrderAmountService {

	public void receiveOrder(Order order) {
		System.out.println("RejectedOrderAmountService.receiveOrder() "+order);
	}

}
