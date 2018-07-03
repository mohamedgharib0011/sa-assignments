package webshop.product.service.dto;

/**
 * used for adding new product in product component
 * 
 * @author mbeshir
 *
 */
public class ProductDTO {

	private String productNumber;

	private double price;

	private String name;

	private String description;

	private String supplierNumber;

	public String getProductNumber() {
		return productNumber;
	}
	
	public ProductDTO() {
		super();
	}



	public ProductDTO(String productNumber, double price, String name, String description) {
		super();
		this.productNumber = productNumber;
		this.price = price;
		this.name = name;
		this.description = description;
	}



	public ProductDTO(String productNumber, double price, String name, String description,
			String supplierNumber) {
		super();
		this.productNumber = productNumber;
		this.price = price;
		this.name = name;
		this.description = description;
		this.supplierNumber = supplierNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
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

}
