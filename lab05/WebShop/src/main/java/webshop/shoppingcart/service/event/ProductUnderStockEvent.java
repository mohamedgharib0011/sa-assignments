package webshop.shoppingcart.service.event;

public class ProductUnderStockEvent {

	private String productNumber;

	public ProductUnderStockEvent(String productNumber) {
		super();
		this.productNumber = productNumber;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	
}
