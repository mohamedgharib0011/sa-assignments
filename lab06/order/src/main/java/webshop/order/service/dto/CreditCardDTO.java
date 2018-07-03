package webshop.order.service.dto;

import java.util.Date;

public class CreditCardDTO {

	private String cardNumber;

	private Date validationDate;

	public CreditCardDTO() {
		super();
	}

	public CreditCardDTO(String cardNumber, Date validationDate) {
		super();
		this.cardNumber = cardNumber;
		this.validationDate = validationDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}

}
