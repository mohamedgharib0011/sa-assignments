package integration;

public class Order {

	private String ordernumber;
	
	private double amount;
	

	public Order() {
		super();
	}

	public Order(String ordernumber, double amount) {
		super();
		this.ordernumber = ordernumber;
		this.amount = amount;
	}

	public String getOrdernumber() {
		return ordernumber;
	}

	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [ordernumber=" + ordernumber + ", amount=" + amount + "]";
	}
	
	
	
}
