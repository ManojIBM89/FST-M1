package Activities;

public class BankAccount {
	private Integer balance;

	// create a constructor
	public BankAccount(Integer initialBalance) {
		balance = initialBalance;
	}

	// add method to calculate
	// balance amount after withdrawal
	public Integer withdraw(Integer amount) {
		if (balance < amount) {
			throw new NotEnoughFundsException(amount, balance);
		}
		balance -= amount;
		return balance;
	}

}