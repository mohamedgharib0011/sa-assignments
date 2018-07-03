package webshop.shared.dto;

import java.util.ArrayList;
/** 
 * 
 * @author mbeshir
 *
 */
public class ShoppingCartDTO {
	private String cardNumber;
	
	ArrayList<CartLineDTO> cartlineList = new ArrayList<CartLineDTO>();

	public String getCartNumber() {
		return cardNumber;
	}

	public void setCartNumber(String cartid) {
		this.cardNumber = cartid;
	}

	public ArrayList<CartLineDTO> getCartlineList() {
		return cartlineList;
	}

	public void setCartlineList(ArrayList<CartLineDTO> cartlineList) {
		this.cartlineList = cartlineList;
	}

	

}
