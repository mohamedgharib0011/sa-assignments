package webshop.customer.service;

import webshop.customer.domain.Account;
import webshop.customer.domain.Customer;
import webshop.customer.service.dto.CustomerDTO;

/**
 * used for conversion between {@link Customer} and {@link CustomerDTO}
 * 
 * @author mbeshir
 *
 */
public class CustomerAdapter {

	/**
	 * construct {@link CustomerDTO} from {@link Customer}
	 * 
	 * @param customer
	 * @return {@link CustomerDTO}
	 */
	public static CustomerDTO getCustomerDTO(Customer customer) {
		CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerNumber(), customer.getFirstName(),
				customer.getLastName(), customer.getEmail(), customer.getPhone());
		Account account = customer.getAccount();

		if (account != null) {
			customerDTO.setAccountNumber(account.getAccountNumber());
			customerDTO.setUsername(account.getUsername());
		}

		return customerDTO;

	}

	/**
	 * construct {@link Customer} from {@link CustomerDTO}
	 * 
	 * @param customerDTO
	 * @return {@link Customer}
	 */
	public static Customer getCustomer(CustomerDTO customerDTO) {

		Customer customer = new Customer();
		customer.setFirstName(customerDTO.getFirstName());
		customer.setLastName(customerDTO.getLastName());
		customer.setEmail(customerDTO.getEmail());
		customer.setPhone(customerDTO.getPhone());
		customer.setCustomerNumber(customerDTO.getCustomerNumber());
		customer.setAccount(
				new Account(customerDTO.getAccountNumber(), customerDTO.getUsername(), customerDTO.getPassword()));

		return customer;

	}

}
