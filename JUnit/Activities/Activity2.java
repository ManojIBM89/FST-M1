package Activities;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class Activity2 {
	
	@Test
	void notEnoughFunds() {
		
		BankAccount account = new BankAccount(20);
		
		assertThrows(NotEnoughFundsException.class, () ->account.withdraw(30),
		"Balance must be less than amount withdraw");
		
	}
	
	@Test
	void EnoughFunds() {
		BankAccount account = new BankAccount(100);
		
		int expectedBalance=0;
		
		assertDoesNotThrow( () -> account.withdraw(10));
		
		assertEquals(expectedBalance, account.withdraw(90));
	}


}