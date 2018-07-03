package webshop.shoppingcart.domain;

/**  
 * CardLine (Value Object)
 * @author mbeshir
 *
 */
public final class CartLine {
	private int quantity;
	private Product product;
	
	public CartLine(int quantity, Product product) {
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

}
