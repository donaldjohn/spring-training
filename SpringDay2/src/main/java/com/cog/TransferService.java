package com.cog;

import org.springframework.stereotype.Service;

@Service
public class TransferService {
	
	public double checkBalance(long account){
//		System.out.println("Account number is " +  account);
		System.out.println("Checking Balance");
		double balance = account * Math.random();		
		return balance;
	}

	public boolean fundsTransfer(long account1, long account2, double amount){
//		System.out.println("Account number is " +  account1 + " : " + account2);
		
		if(account1 != account2){
			return true;
		}
		
		return false;
	}
		
}
