package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import shop.shopping.service.ShoppingCartDTO;

@Component
public class OrderProxy {
	
	@Autowired
	OrderFeignClient orderFeignClient;

	public void createOrder(ShoppingCartDTO shoppingCartDTO) {	
		
		System.out.println("********** OrderProxy.createOrder()");
		orderFeignClient.createOrder(shoppingCartDTO);	
		
	};
	
	@FeignClient("ORDER")
	interface OrderFeignClient{
		
		@RequestMapping(value="/order/create", method=RequestMethod.POST)
		void createOrder(ShoppingCartDTO shoppingCartDTO);
	}
}
