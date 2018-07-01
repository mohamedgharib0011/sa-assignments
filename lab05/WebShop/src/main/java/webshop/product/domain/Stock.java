package webshop.product.domain;

/**
 * Stock (Value Object)
 * 
 * @author mbeshir
 *
 */
public final class Stock {
	int quantity;
	String locationcode;

	public Stock(int quantity, String locationcode) {
		super();
		this.quantity = quantity;
		this.locationcode = locationcode;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getLocationcode() {
		return locationcode;
	}

	/**
	 * decrease stock amount
	 */
	public void decreaseStock(int quantity) {
		this.quantity -= quantity;
	}

	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", locationcode=" + locationcode + "]";
	}

}
