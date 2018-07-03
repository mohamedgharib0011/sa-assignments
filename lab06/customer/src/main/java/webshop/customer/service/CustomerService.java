package webshop.customer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.customer.domain.Customer;
import webshop.customer.repository.CustomerRepository;
import webshop.customer.service.dto.CustomerDTO;

/**
 * 
 * @author mbeshir
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	/**
	 * list all customers with their accounts
	 * 
	 * @return List<{@link CustomerDTO }>
	 */
	public List<CustomerDTO> listCustomers() {
		List<CustomerDTO> customerDTOs = new ArrayList<>();
		customerRepository.findAll().forEach(customer -> {
			customerDTOs.add(CustomerAdapter.getCustomerDTO(customer));
		});
		return customerDTOs;

	}

	/**
	 * adding new customer
	 * 
	 * @param customerDTO
	 */
	public void addCustomer(CustomerDTO customerDTO) {
		customerRepository.save(CustomerAdapter.getCustomer(customerDTO));
	}

	/**
	 * get customer by customerNumber
	 * @param customerNumber
	 * @return {@link CustomerDTO}
	 */
	public CustomerDTO getCustomer(String customerNumber) {
		Optional<Customer> customerOPT = customerRepository.findById(customerNumber);
		return customerOPT.isPresent() ? CustomerAdapter.getCustomerDTO(customerOPT.get()) : null;

	}

}
