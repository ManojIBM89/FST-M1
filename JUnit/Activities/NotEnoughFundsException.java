package Activities;

@SuppressWarnings("serial")
public class NotEnoughFundsException extends RuntimeException {

	public NotEnoughFundsException(int amount, int balance) {
		super("Attempted to withdraw" + amount + "with a balance of" + balance);
	}

}