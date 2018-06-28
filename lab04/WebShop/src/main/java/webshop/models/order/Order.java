package webshop.models.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Order {
	
	@Id
	private Integer orderId;
	
	private double totalAmount;
	
	private List<OrderLine> oderLines=new ArrayList<>();

	
	public Order() {
		super();
	}

	public Order(Integer orderId) {
		super();
		this.orderId = orderId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	

	public List<OrderLine> getOderLines() {
		return oderLines;
	}

	public void setOderLines(List<OrderLine> oderLines) {
		this.oderLines = oderLines;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", totalAmount=" + totalAmount + ", oderLines=" + oderLines + "]";
	}

}
