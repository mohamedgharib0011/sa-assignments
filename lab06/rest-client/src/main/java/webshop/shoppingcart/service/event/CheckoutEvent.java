package webshop.shoppingcart.service.event;

public class CheckoutEvent {

	private String message;

	public CheckoutEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
