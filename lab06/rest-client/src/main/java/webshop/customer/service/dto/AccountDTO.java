package webshop.customer.service.dto;

public class AccountDTO {
	
	private String accountNumber;
	
	private String username;

	public AccountDTO() {
		super();
	}

	public AccountDTO(String accountNumber, String username) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
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

	@Override
	public String toString() {
		return "AccountDTO [accountNumber=" + accountNumber + ", username=" + username + "]";
	}
	
	
	
	
	
}
