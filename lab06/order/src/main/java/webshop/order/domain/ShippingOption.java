package webshop.order.domain;

/**
 * ShippingOption (Value Object)
 * 
 * @author mbeshir
 *
 */
public final class ShippingOption {

	private String name;

	private double price;

	private String shipper;

	public ShippingOption(String name, double price, String shipper) {
		super();
		this.name = name;
		this.price = price;
		this.shipper = shipper;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getShipper() {
		return shipper;
	}

	@Override
	public String toString() {
		return "ShippingOption [name=" + name + ", price=" + price + ", shipper=" + shipper + "]";
	}
	

}
