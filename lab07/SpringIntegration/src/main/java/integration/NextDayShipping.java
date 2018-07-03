package integration;

public class NextDayShipping {
	
	public Order receiveOrder(Order order) {
		System.out.println("NextDayShipping.receiveOrder() "+order);
		return order;
	}

}
