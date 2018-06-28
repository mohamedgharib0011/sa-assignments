package webshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.models.order.Order;
import webshop.models.product.Product;
import webshop.models.shoppingcart.ShoppingCart;
import webshop.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductCategoryService productService;

	public Order getOrder(Integer orderId) {
		return orderRepository.findById(orderId).orElse(null);
	}

	public void createOrder(Integer orderId, ShoppingCart shoppingCart) {
		Order order = new Order(orderId);

		shoppingCart.getCartLines().forEach(line -> {
			Product product = productService.getProduct(line.getProductnumber());
			order.setTotalAmount(order.getTotalAmount() + (product.getPrice() * line.getQuantity()));
			order.getOderLines().add(new webshop.models.order.OrderLine(line.getQuantity(),
					new webshop.models.order.Product(product.getNum(), product.getName(), product.getPrice())));
		});

		orderRepository.save(order);
	}

}
