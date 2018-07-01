package webshop.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webshop.customer.domain.Account;
import webshop.customer.domain.Customer;
import webshop.customer.repository.CustomerRepository;
import webshop.customer.service.dto.AccountDTO;
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
			customerDTOs.add(constructCustomerDTO(customer));
		});
		return customerDTOs;

	}

	/**
	 * initial data for testing
	 */
	public void addCustomer() {

		Customer customer = new Customer();

		customer.setCustomerNumber("111");
		customer.setFirstName("Mohamed");
		customer.setLastName("Gharib");
		customer.setEmail("mgharib@mum.edu");
		customer.setPhone("646622338");

		customer.setAccount(new Account("111", "mbeshir", "44444"));

		customerRepository.save(customer);

	}

	/**
	 * construct CustomerDTO from Customer
	 * 
	 * @param customer
	 * @return {@link CustomerDTO}
	 */
	private CustomerDTO constructCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerNumber(), customer.getFirstName(),
				customer.getLastName(), customer.getEmail(), customer.getPhone());
		Account account = customer.getAccount();

		if (account != null)
			customerDTO.setAccountDTO(new AccountDTO(account.getAccountNumber(), account.getUsername()));

		return customerDTO;

	}

}
