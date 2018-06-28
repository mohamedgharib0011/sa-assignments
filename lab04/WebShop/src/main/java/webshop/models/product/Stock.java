package webshop.models.product;

public final class Stock {

	private Integer quantity;

	private Integer locationCode;

	public Stock(Integer quantity, Integer locationCode) {
		super();
		this.quantity = quantity;
		this.locationCode = locationCode;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getLocationCode() {
		return locationCode;
	}

}
