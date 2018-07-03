package webshop.order.service;

import webshop.order.domain.Order;
import webshop.order.domain.Product;
import webshop.order.service.dto.OrderDTO;
import webshop.order.service.dto.OrderLineDTO;
import webshop.order.service.dto.ProductDTO;

/**
 * used for conversion between {@link Order} and {@link OrderDTO}
 * 
 * @author mbeshir
 *
 */
public class OrderAdapter {

	/**
	 * convert from {@link Order} to {@link OrderDTO}
	 * 
	 * @param order
	 * @return {@link OrderDTO}
	 */
	public static OrderDTO getOrderDTO(Order order) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setDate(order.getDate());
		orderDTO.setOrdernumber(order.getOrdernumber());
		orderDTO.setStatus(order.getStatus().toString());

		order.getOrderlineList().forEach(orderLine -> {
			Product product = orderLine.getProduct();

			orderDTO.getOrderLineDTOs().add(new OrderLineDTO(orderLine.getQuantity(),
					new ProductDTO(product.getProductnumber(), product.getName(), product.getPrice())));
		});

		return orderDTO;

	}

}
