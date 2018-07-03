package integration;

public class WarehouseService {

	public Order receiveOrder(Order order) {
		System.out.println("WarehouseService.receiveOrder() "+order);
		return order;
	}

}
