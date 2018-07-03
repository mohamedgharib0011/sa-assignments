package webshop.customer.domain;

/** 
 * Account (Value Object)
 * @author mbeshir
 *
 */
public final class Account {
	
	private String accountNumber;
	
	private String username;
	
	private String password;
	
	public Account(String accountNumber, String username, String password) {
		super();
		this.accountNumber = accountNumber;
		this.username = username;
		this.password = password;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

	
	

}
