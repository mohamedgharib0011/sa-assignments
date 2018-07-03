package webshop.shoppingcart.service;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import webshop.shoppingcart.integration.EmailSenderService;
import webshop.shoppingcart.service.event.CheckoutEvent;
import webshop.shoppingcart.service.event.ProductUnderStockEvent;

/**
 * listener for events
 * 
 * @author mbeshir
 *
 */
@Service
@EnableAsync
public class ShoppingCartListener {

	/**
	 * listener for shopping card checkout event
	 * 
	 * @param checkoutEvent
	 */
	@EventListener
	public void checkoutHandler(CheckoutEvent checkoutEvent) {
		System.out.println("*************** " + checkoutEvent.getMessage());
	}

	/** 
	 * listener for product under-stock event
	 * @param productUnderStockEvent
	 */
	@EventListener
	public void productUnderStockEventHandler(ProductUnderStockEvent productUnderStockEvent) {
		EmailSenderService.sendProductUnderStockEmail(productUnderStockEvent.getProductNumber());
	}

}
