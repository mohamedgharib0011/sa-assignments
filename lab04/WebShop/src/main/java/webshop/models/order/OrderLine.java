package webshop.models.order;

public final class OrderLine {

	private Integer quantity;

	private Product product;

	public OrderLine() {
		super();
	}

	public OrderLine(Integer quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}

	@Override
	public String toString() {
		return "OrderLine [quantity=" + quantity + ", product=" + product + "]";
	}
	
	

}
