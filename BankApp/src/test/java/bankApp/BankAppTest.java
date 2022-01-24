package bankApp;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BankAppTest 
{

	@Test
	public void firstBankAppTest()
	{
		
		LogginSys loggsys = new LogginSys();
		Bank bank = new Bank();
		
			
		
		double x = loggsys.accBalance("Greg");			
		double y = loggsys.accBalance("John");
		
		assertTrue(x > -1);
		assertNotNull(y);
		
	}
	
	
	
}
