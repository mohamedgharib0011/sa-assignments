package webshop.shoppingcart.domain;

/**
 * Product (Value Object)
 * 
 * @author mbeshir
 *
 */
public final class Product {

	private String productnumber;

	private double price;

	private String name;

	public Product(String productnumber, String name, double price) {
		super();
		this.productnumber = productnumber;
		this.price = price;
		this.name = name;
	}

	public String getProductnumber() {
		return productnumber;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

}
