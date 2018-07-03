package webshop.product.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Product (Entity)
 * 
 * @author mbeshir
 *
 */
@Document
public class Product {

	@Id
	private String productNumber;

	private double price;

	private String name;

	private String description;

	private Stock stock;

	private List<Review> reviews = new ArrayList<>();

	private String supplierNumber;

	public Product(String productNumber, String name, String description, double price, String supplierNumber) {
		super();
		this.productNumber = productNumber;
		this.price = price;
		this.name = name;
		this.description = description;
		this.supplierNumber = supplierNumber;
	}

	public Product() {

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSupplierNumber() {
		return supplierNumber;
	}

	public void setSupplierNumber(String supplierNumber) {
		this.supplierNumber = supplierNumber;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productnumber) {
		this.productNumber = productnumber;
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

	public void setName(String description) {
		this.name = description;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

}
