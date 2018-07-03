package supplier;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private String ordernumber;

	private double amount;

	private List<OrderLine> orderlines = new ArrayList<>();

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(String ordernumber, double amount, List<OrderLine> orderlines) {
		super();
		this.ordernumber = ordernumber;
		this.amount = amount;
		this.orderlines = orderlines;
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

	public List<OrderLine> getOrderlines() {
		return orderlines;
	}

	public void setOrderlines(List<OrderLine> orderlines) {
		this.orderlines = orderlines;
	}

}
