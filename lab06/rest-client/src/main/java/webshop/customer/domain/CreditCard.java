package webshop.customer.domain;

import java.util.Date;

/**
 * CreditCard (Value Object)
 * 
 * @author mbeshir
 *
 */
public final class CreditCard {

	private String cardNumber;

	private Date validationDate;

	public CreditCard(String cardNumber, Date validationDate) {
		super();
		this.cardNumber = cardNumber;
		this.validationDate = validationDate;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public Date getValidationDate() {
		return validationDate;
	}

	@Override
	public String toString() {
		return "CreditCard [cardNumber=" + cardNumber + ", validationDate=" + validationDate + "]";
	}
	
	

}
