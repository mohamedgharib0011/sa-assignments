package greeting.models;

public class Stock {
	
	private Integer quantity;
	
	private Integer locationCode;
	

	public Stock() {
		super();
	}
	
	public Stock(Integer quantity, Integer locationCode) {
		super();
		this.quantity = quantity;
		this.locationCode = locationCode;
	}



	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(Integer locationCode) {
		this.locationCode = locationCode;
	}
	
	

}
