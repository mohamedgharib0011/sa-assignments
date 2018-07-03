package webshop.events;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author mbeshir
 *
 */
public class OrderConfirmationEvent {

	private String customerNumber;

	private Map<String, Integer> productMap = new HashMap<>();
	
	public OrderConfirmationEvent() {
		super();
	}

	public OrderConfirmationEvent(String customerNumber) {
		super();
		this.customerNumber = customerNumber;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public void addOrderline(String productNumber, int quantity) {
		this.productMap.put(productNumber, quantity);
	}

	public Map<String, Integer> getProductMap() {
		return productMap;
	}
	
}
