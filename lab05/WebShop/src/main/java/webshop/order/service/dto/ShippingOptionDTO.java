package webshop.order.service.dto;

public class ShippingOptionDTO {
	
	private String name;

	private double price;

	private String shipper;
	
	
	public ShippingOptionDTO() {
		super();
	}

	public ShippingOptionDTO(String name, double price, String shipper) {
		super();
		this.name = name;
		this.price = price;
		this.shipper = shipper;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}


}
