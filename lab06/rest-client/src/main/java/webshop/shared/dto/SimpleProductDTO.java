package webshop.shared.dto;

/**
 * 
 * @author mbeshir
 *
 */
public class SimpleProductDTO {
	private String productnumber;
	private double price;
	private String name;

	private int stockAmount;

	public SimpleProductDTO(String productnumber, String name, double price) {
		super();
		this.productnumber = productnumber;
		this.price = price;
		this.name = name;
	}

	public SimpleProductDTO() {
	}
	
	public int getStockAmount() {
		return stockAmount;
	}

	public void setStockAmount(int stockAmount) {
		this.stockAmount = stockAmount;
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
