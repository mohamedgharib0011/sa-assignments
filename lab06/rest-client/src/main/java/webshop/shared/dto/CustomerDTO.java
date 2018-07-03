package webshop.shared.dto;

public class CustomerDTO {
	
	private String customerNumber;

	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	private String accountNumber;
	
	private String username;
	
	private String password;
	
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerNumber=" + customerNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", accountNumber=" + accountNumber + ", username="
				+ username + ", password=" + password + "]";
	}
	
}
