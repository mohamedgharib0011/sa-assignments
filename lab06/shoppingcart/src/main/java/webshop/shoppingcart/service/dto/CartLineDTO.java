package webshop.shoppingcart.service.dto;


/**  
 * 
 * @author mbeshir
 *
 */
public class CartLineDTO {
	
	private int quantity;
	
	private SimpleProductDTO product;
	

	public CartLineDTO() {
		super();
	}

	public CartLineDTO(int quantity, SimpleProductDTO product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}

	public SimpleProductDTO getProduct() {
		return product;
	}

	public void setProduct(SimpleProductDTO product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
