package integration;

public class NormalShippingService {

	public Order receiveOrder(Order order) {
		System.out.println("NormalShippingService.receiveOrder() " + order);
		return order;
	}

}
