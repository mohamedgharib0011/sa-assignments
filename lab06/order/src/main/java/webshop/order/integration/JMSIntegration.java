package webshop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import webshop.events.OrderConfirmationEvent;

@Service
public class JMSIntegration {

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendOrderConfirmationMessage(OrderConfirmationEvent orderConfirmationEvent ) {
		jmsTemplate.convertAndSend("orderConfirmationQueue", orderConfirmationEvent);
	}

}
