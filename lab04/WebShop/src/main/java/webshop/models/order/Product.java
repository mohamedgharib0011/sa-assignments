package webshop.models.order;

public final class Product {

	private Integer num;

	private String name;

	private double price;
	
	public Product() {
		super();
	}

	public Product(Integer num, String name,double price) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public double getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
