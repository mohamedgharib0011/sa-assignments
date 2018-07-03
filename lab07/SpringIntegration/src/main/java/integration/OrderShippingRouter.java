package integration;

public class OrderShippingRouter {

	public String route(Order order) {
		return order.getAmount() > 175 ? "nextDayShippingInputChannel" : "normalShippingInputChannel";

	}

}
