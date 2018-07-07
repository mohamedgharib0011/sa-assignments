package account;

public class Account {
	private String accountNumber;

	private double amount;

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String accountNumber, double amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
