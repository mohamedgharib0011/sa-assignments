package webshop.order.service.dto;

/**
 * 
 * @author mbeshir
 *
 */
public class ProductDTO {
	private String productnumber;
	private double price;
	private String name;

	public ProductDTO(String productnumber, String name, double price) {
		super();
		this.productnumber = productnumber;
		this.price = price;
		this.name = name;
	}

	public ProductDTO() {
	}
	
	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProductDTO [productnumber=" + productnumber + ", price=" + price + ", name=" + name + "]";
	}

}
