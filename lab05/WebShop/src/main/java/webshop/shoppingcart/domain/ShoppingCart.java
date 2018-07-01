package webshop.shoppingcart.domain;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author mbeshir
 *
 */
@Document
public class ShoppingCart {

	@Id
	private String cartNumber;

	ArrayList<CartLine> cartlineList = new ArrayList<CartLine>();
	
	public ShoppingCart(String cartNumber) {
		super();
		this.cartNumber = cartNumber;
	}

	/**
	 * add product to card or increase quantity of already exist
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addToCart(Product product, int quantity) {

		// find the product if exist
		Optional<CartLine> opCardLine = cartlineList.stream()
				.filter(cardLine -> cardLine.getProduct().getProductnumber().equals(product.getProductnumber()))
				.findAny();
		
		// increase the product quantity if exist or add new
		if (opCardLine.isPresent()) {
			CartLine currentCartLine = opCardLine.get();
			cartlineList.remove(currentCartLine);
			cartlineList.add(new CartLine(quantity + currentCartLine.getQuantity(), product));

		} else {
			cartlineList.add(new CartLine(quantity, product));
		}

	}

	/**
	 * remove the product from the cart whatever the quantity is.
	 * 
	 * @param product
	 */
	public void removeFromCart(Product product) {

		cartlineList.removeIf(cardLine -> cardLine.getProduct().getProductnumber().equals(product.getProductnumber()));
	}


	public String getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(String cartNumber) {
		this.cartNumber = cartNumber;
	}

	public ArrayList<CartLine> getCartlineList() {
		return cartlineList;
	}

	public void setCartlineList(ArrayList<CartLine> cartlineList) {
		this.cartlineList = cartlineList;
	}

}
