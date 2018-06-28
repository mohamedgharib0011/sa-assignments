package greeting.models;

public class CartLine {

	private Product product;

	private Integer quantity;

	public Product getProduct() {
		return product;
	}

	public CartLine() {
	}

	public CartLine(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
