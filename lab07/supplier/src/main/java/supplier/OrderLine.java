package supplier;

public class OrderLine {
	
	private String productnumber;
	
	private int quantity;
	
	public OrderLine() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderLine(String productnumber, int quantity) {
		super();
		this.productnumber = productnumber;
		this.quantity = quantity;
	}



	public String getProductnumber() {
		return productnumber;
	}

	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
