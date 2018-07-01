package webshop.product.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import webshop.product.service.event.NewProductEvent;
import webshop.shared.event.OrderConfirmationEvent;

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
	@EventListener
	public void orderConfirmationEventHandler(OrderConfirmationEvent orderConfirmationEvent) {
		Map<String, Integer> productMap = orderConfirmationEvent.getProductMap();
		productMap.keySet().forEach(productNumber -> {
			productService.decreaseProductStock(productNumber, productMap.get(productNumber));
		});
	}
}
