package shop.order.integration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.order.service.OrderCustomerDTO;

@Component
public class CustomerProxy {
	@Autowired
	private CustomerFeignClient customerFeignClient;

	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		return customerFeignClient.getOrderCustomerDTO(customerNumber);
	};

	@FeignClient("CUSTOMER")
	interface CustomerFeignClient {
		@RequestMapping(value = "/ordercustomer/{customerNumber}")
		OrderCustomerDTO getOrderCustomerDTO(@PathVariable("customerNumber") String customerNumber);
	}
}
