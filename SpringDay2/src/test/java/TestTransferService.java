import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cog.TransferService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class TestTransferService {
	
	@Autowired
	private TransferService service;

	@Test
	public void testCheckBalance(){
		
		int account = 11111112;		
		double result = service.checkBalance(account);
		System.out.println("Balance is : " + result);

		assertFalse(false);
		
	}
	
//	@Test
	public void testFundsTransfer(){
		
		int account1 = 123456778;
		int account2 = 123456779;
		double amount = 2343.45;
		
		boolean result = service.fundsTransfer(account1, account2, amount);

		assertEquals("For same accounts should transfer", true, result);
		
	}
	
//	@Test
	public void testFundsTransferSameAccounts(){
		
		int account1 = 123456778;
		int account2 = 123456778;
		double amount = 2343.45;
		
		boolean result = service.fundsTransfer(account1, account2, amount);

		assertEquals("For same accounts should transfer", false, result);
		
	}
	
	

}
