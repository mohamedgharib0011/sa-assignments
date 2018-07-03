package integration.activators;

import integration.model.Order;

/** 
 * handling fedex shipping
 * @author mbeshir
 *
 */
public class FedexShippingService {
	
	public void receiveOrder(Order order) {
		System.out.println("FedexShippingService.receiveOrder() "+order);
	}

}
