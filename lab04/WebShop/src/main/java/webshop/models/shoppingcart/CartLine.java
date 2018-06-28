package webshop.models.shoppingcart;

public final class CartLine {

	private Integer productnumber;

	private Integer quantity;


	public CartLine(Integer productnumber, Integer quantity) {
		this.productnumber = productnumber;
		this.quantity = quantity;
	}
	
	public Integer getProductnumber() {
		return productnumber;
	}

	public Integer getQuantity() {
		return quantity;
	}


}
