package webshop.customer.service.dto;

public class CustomerDTO {
	
	private String customerNumber;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private AccountDTO accountDTO;
	
	public CustomerDTO() {
		super();
	}

	public CustomerDTO(String customerNumber, String firstName, String lastName, String email, String phone) {
		super();
		this.customerNumber = customerNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public AccountDTO getAccountDTO() {
		return accountDTO;
	}

	public void setAccountDTO(AccountDTO accountDTO) {
		this.accountDTO = accountDTO;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", accountDTO=" + accountDTO + "]";
	}
	
	
	
	
	
	

}
