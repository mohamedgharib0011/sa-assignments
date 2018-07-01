package webshop.shoppingcart.integration;

public class EmailSenderService {

	public static void sendProductUnderStockEmail(String productNumber) {
		System.out.println("******** A product under-stock email has been send for product " + productNumber);
	}

}
