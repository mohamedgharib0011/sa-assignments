package webshop.order.service.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDTO {
	
	private String ordernumber;
	
	private Date date;
	
	private String status;
	
	private List<OrderLineDTO> orderLineDTOs=new ArrayList<>();
	
	public String getOrdernumber() {
		return ordernumber;
	}
	public void setOrdernumber(String ordernumber) {
		this.ordernumber = ordernumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderLineDTO> getOrderLineDTOs() {
		return orderLineDTOs;
	}
	public void setOrderLineDTOs(List<OrderLineDTO> orderLineDTOs) {
		this.orderLineDTOs = orderLineDTOs;
	}
	@Override
	public String toString() {
		return "OrderDTO [ordernumber=" + ordernumber + ", date=" + date + ", status=" + status + ", orderLineDTOs="
				+ orderLineDTOs + "]";
	}
	
	
	

}
