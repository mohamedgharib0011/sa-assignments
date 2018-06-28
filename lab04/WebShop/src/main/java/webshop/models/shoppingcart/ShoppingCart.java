package webshop.models.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class ShoppingCart {

	@Id
	private Integer cartNum;

	private List<CartLine> cartLines = new ArrayList<>();
	
	

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Integer cartNum) {
		super();
		this.cartNum = cartNum;
	}

	public void addToCart(Integer productnumber, Integer quantity) {
		cartLines.add(new CartLine(productnumber, quantity));
	}

	public Integer getCartNum() {
		return cartNum;
	}

	public void setCartNum(Integer cartNum) {
		this.cartNum = cartNum;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}


}
