package webshop.models.product;

import org.springframework.data.annotation.Id;

public class Product {

	@Id
	private Integer num;

	private String name;

	private String desc;

	private double price;

	private Stock stock;

	public Product(Integer num, String name, String desc, double price) {
		super();
		this.num = num;
		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	public Product() {
		super();
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
	

}
