package webshop.order.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import webshop.events.OrderConfirmationEvent;
import webshop.order.domain.Address;
import webshop.order.domain.CreditCard;
import webshop.order.domain.Order;
import webshop.order.domain.OrderFactory;
import webshop.order.domain.Product;
import webshop.order.domain.ShippingOption;
import webshop.order.integration.EmailSenderService;
import webshop.order.integration.JMSIntegration;
import webshop.order.integration.LoggerService;
import webshop.order.repository.OrderRepository;
import webshop.order.service.dto.AddressDTO;
import webshop.order.service.dto.CreditCardDTO;
import webshop.order.service.dto.OrderDTO;
import webshop.order.service.dto.ShippingOptionDTO;
import webshop.order.service.dto.ShoppingCartDTO;

/**
 * order reception
 * 
 * @author mbeshir
 *
 */
@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Autowired
	JMSIntegration jmsIntegration;

	/**
	 * get order by orderNumber
	 * 
	 * @param orderNumber
	 * @return {@link OrderDTO}
	 */
	public OrderDTO getOrder(String orderNumber) {
		Optional<Order> optOrder = orderRepository.findById(orderNumber);
		if (optOrder.isPresent()) {
			return OrderAdapter.getOrderDTO(optOrder.get());
		} else
			return null;
	}

	/**
	 * create order from {@link ShoppingCartDTO}
	 * 
	 * @param cart
	 */
	public void createOrder(ShoppingCartDTO cart) {
		Order order = OrderFactory.createOrder(cart);
		order = orderRepository.save(order);
	}

	/**
	 * add customer to a certain order
	 * 
	 * @param orderNumber
	 * @param customerNumber
	 */
	public void setOrderCustomer(String orderNumber, String customerNumber) {
		orderRepository.findById(orderNumber).ifPresent(order -> {
			order.setCustomerNumber(customerNumber);
			orderRepository.save(order);
		});

	}

	/**
	 * add credit card information to a certain order
	 * 
	 * @param orderNumber
	 * @param creditCardDTO
	 */
	public void setOrderCreditCard(String orderNumber, CreditCardDTO creditCardDTO) {
		orderRepository.findById(orderNumber).ifPresent(order -> {
			order.setCreditCard(new CreditCard(creditCardDTO.getCardNumber(), creditCardDTO.getValidationDate()));
			orderRepository.save(order);
		});
	}

	/**
	 * add shipping option to a certain order
	 * 
	 * @param orderNumber
	 * @param shippingOptionDTO
	 */
	public void setOrderShippingOption(String orderNumber, ShippingOptionDTO shippingOptionDTO) {
		orderRepository.findById(orderNumber).ifPresent(order -> {
			order.setShippingOption(new ShippingOption(shippingOptionDTO.getName(), shippingOptionDTO.getPrice(),
					shippingOptionDTO.getShipper()));
			orderRepository.save(order);
		});
	}

	/**
	 * add shipping address to a certain order
	 * 
	 * @param orderNumber
	 * @param addressDTO
	 */
	public void setOrderShippingAddress(String orderNumber, AddressDTO addressDTO) {
		orderRepository.findById(orderNumber).ifPresent(order -> {
			order.setShippingAddress(new Address(addressDTO.getStreet(), addressDTO.getCity(), addressDTO.getZip(),
					addressDTO.getCountry()));
			orderRepository.save(order);
		});
	}

	/**
	 * add billing address to a certain order
	 * 
	 * @param orderNumber
	 * @param addressDTO
	 */
	public void setOrderBillingAddress(String orderNumber, AddressDTO addressDTO) {
		orderRepository.findById(orderNumber).ifPresent(order -> {
			order.setBillingddress(new Address(addressDTO.getStreet(), addressDTO.getCity(), addressDTO.getZip(),
					addressDTO.getCountry()));
			orderRepository.save(order);
		});
	}

	/**
	 * find the order with the passed orderNumber and confirm it then publish order
	 * confirmation event.
	 * 
	 * @param orderNumber
	 */
	public void confirmOrder(String orderNumber) {
		orderRepository.findById(orderNumber).ifPresent(order -> {
			order.confirm();
			orderRepository.save(order);
			EmailSenderService.sendEmail();
			LoggerService.logOrder();

			// publish order confirmation event
			OrderConfirmationEvent orderConfirmationEvent = new OrderConfirmationEvent(order.getCustomerNumber());
			order.getOrderlineList().forEach(orderLine -> {
				Product product = orderLine.getProduct();
				orderConfirmationEvent.addOrderline(product.getProductnumber(), orderLine.getQuantity());
			});

			eventPublisher.publishEvent(orderConfirmationEvent);
			jmsIntegration.sendOrderConfirmationMessage(orderConfirmationEvent);
			
		});
	}

}
