package webshop.order.domain;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Order (Entity, Root)
 * 
 * @author mbeshir
 *
 */
@Document
public class Order {

	@Id
	private String ordernumber;

	private Date date;

	private OrderStatus status;

	private String customerNumber;

	private Address shippingAddress;

	private Address billingddress;

	private ShippingOption shippingOption;

	private CreditCard creditCard;

	private ArrayList<OrderLine> orderlineList = new ArrayList<OrderLine>();

	public Order() {
	}

	public Order(String orderNumber, Date date, OrderStatus status) {
		super();
		this.ordernumber = orderNumber;
		this.date = date;
		this.status = status;
	}

	/**
	 * add new orderLine to the current order
	 * 
	 * @param orderLine
	 */
	public void addOrderLine(OrderLine orderLine) {
		orderlineList.add(orderLine);
	}

	/**
	 * confirm order
	 */
	public void confirm() {

		status = OrderStatus.CONFIRMED;
	}

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

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public ArrayList<OrderLine> getOrderlineList() {
		return orderlineList;
	}

	public void setOrderlineList(ArrayList<OrderLine> orderlineList) {
		this.orderlineList = orderlineList;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Address getBillingddress() {
		return billingddress;
	}

	public void setBillingddress(Address billingddress) {
		this.billingddress = billingddress;
	}

	public ShippingOption getShippingOption() {
		return shippingOption;
	}

	public void setShippingOption(ShippingOption shippingOption) {
		this.shippingOption = shippingOption;
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

}
