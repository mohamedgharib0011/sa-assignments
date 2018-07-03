package integration;

public class ShippingService {
	
	public Order receiveOrder(Order order) {
		System.out.println("ShippingService.receiveOrder() "+order);
		return order;
	}

}
