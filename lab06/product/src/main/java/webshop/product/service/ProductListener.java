package webshop.product.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import webshop.events.OrderConfirmationEvent;
import webshop.product.service.event.NewProductEvent;

/**
 * listener for events
 * 
 * @author mbeshir
 *
 */
@Service
@EnableAsync
public class ProductListener {

	@Autowired
	ProductService productService;

	/**
	 * listener for new product event
	 * 
	 * @param newProductEvent
	 */
	@EventListener
	public void newProductHandler(NewProductEvent newProductEvent) {
		System.out.println("*************** " + newProductEvent.getMessage());
	}

	/**
	 * listener for order confirmation event
	 * 
	 * @param orderConfirmationEvent
	 */
	@JmsListener(destination = "orderConfirmationQueue")
	public void receiveMessage(final OrderConfirmationEvent orderConfirmationEvent) {
		System.out.println("************************** ProductListener.receiveMessage()");
		Map<String, Integer> productMap = orderConfirmationEvent.getProductMap();
		productMap.keySet().forEach(productNumber -> {
			productService.decreaseProductStock(productNumber, productMap.get(productNumber));
		});
	}
}
