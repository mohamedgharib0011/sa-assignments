package greeting.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class ShoppingCart {

	@Id
	private Integer cartNum;

	private double totalPrice;

	private List<CartLine> cartLines = new ArrayList<>();
	
	

	public ShoppingCart() {
		super();
	}

	public ShoppingCart(Integer cartNum) {
		super();
		this.cartNum = cartNum;
	}

	public void addToCart(Product product, Integer quantity) {
		totalPrice += (product.getPrice() * quantity);
		cartLines.add(new CartLine(product, quantity));
	}

	public Integer getCartNum() {
		return cartNum;
	}

	public void setCartNum(Integer cartNum) {
		this.cartNum = cartNum;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public List<CartLine> getCartLines() {
		return cartLines;
	}


}
