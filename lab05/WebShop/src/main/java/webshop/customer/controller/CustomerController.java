package webshop.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webshop.customer.service.CustomerService;
import webshop.customer.service.dto.CustomerDTO;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("")
	public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
		return new ResponseEntity<List<CustomerDTO>>(customerService.listCustomers(), HttpStatus.OK);
	}

}
