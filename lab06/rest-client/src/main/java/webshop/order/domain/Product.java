package webshop.order.domain;

/** 
 * Product (Value Object)
 * @author mbeshir
 *
 */
public final class Product {
	String productnumber;
	double price;
	String name;

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

	@Override
	public String toString() {
		return "Product [productnumber=" + productnumber + ", price=" + price + ", name=" + name + "]";
	}
	
}
