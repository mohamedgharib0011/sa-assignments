package webshop.order.service.dto;

public class OrderLineDTO {
	int quantity;
	ProductDTO product;
	
	public OrderLineDTO() {
		super();
	}
	public OrderLineDTO(int quantity, ProductDTO product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderLineDTO [quantity=" + quantity + ", product=" + product + "]";
	}
	
	
	
	

}
