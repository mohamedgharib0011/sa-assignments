package webshop.order.domain;

/**
 * OrderLine (Value Object)
 * 
 * @author mbeshir
 *
 */
public final class OrderLine {
	int quantity;
	Product product;

	public OrderLine(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "OrderLine [quantity=" + quantity + ", product=" + product + "]";
	}
	
	

}
