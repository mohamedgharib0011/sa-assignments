package integration.activators;

import integration.model.Order;

public class DHLShippingService {

	public void receiveOrder(Order order) {
		System.out.println("DHLShippingService.receiveOrder() " + order);
	}

}
