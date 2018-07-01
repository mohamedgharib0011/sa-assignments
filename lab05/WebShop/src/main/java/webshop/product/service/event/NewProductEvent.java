package webshop.product.service.event;

public class NewProductEvent {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public NewProductEvent(String message) {
		super();
		this.message = message;
	}
	

}
