package webshop.order.service;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import webshop.events.OrderConfirmationEvent;

/**
 * listener for events
 * 
 * @author mbeshir
 *
 */
@Service
@EnableAsync
public class OrderListener {

	/**
	 * listener for order confirmation event
	 * 
	 * @param orderConfirmationEvent
	 */
	@EventListener
	public void orderConfirmationEventHandler(OrderConfirmationEvent orderConfirmationEvent) {
		System.out.println(
				"*************** An email has been to customer: " + orderConfirmationEvent.getCustomerNumber());
	}
}
