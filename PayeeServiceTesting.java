package com.sbi.project;

import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sbi.project.layer2.Account;
import com.sbi.project.layer2.Applicant;
import com.sbi.project.layer2.Payee;
import com.sbi.project.layer4.PayeeService;
@SpringBootTest
public class PayeeServiceTesting {
	
	@Autowired
	PayeeService payeeService;
	
	@Test
	void addPayeeServiceTest() {
		Payee payeeObj1 = new Payee();
		payeeObj1.setPayeeName("Seeta");
		payeeObj1.setPayeeAccountNumber(10002);
		payeeObj1.setNickName("siya");
		
		
		Account accObj = new Account();
		accObj.setAccountNumber(10004);
		payeeObj1.setAccount(accObj);
		
		payeeService.addPayeeService(payeeObj1);
	}
		
	@Test
	void loadAllPayeeServiceTest() {
		List<Payee> allPayee = payeeService.findAllPayee(10001);
		
		for (Payee payee : allPayee) {
			System.out.println("Payee Id is "+payee.getPayeeId());
	     	System.out.println("Payee name is "+payee.getPayeeName());
		    System.out.println("Payee account number is "+payee.getPayeeAccountNumber());
		    System.out.println("Payee nickname is "+payee.getNickName());
		    
		    System.out.println("---------------------------");
		
	}
		 
		
	}
	@Test
	void loadPayeeByIdServiceTest()
	{
		Payee payee = payeeService.findPayee(3);
		Assertions.assertTrue(payee!=null);
		
		System.out.println("Payee Id is "+payee.getPayeeId());
     	System.out.println("Payee name is "+payee.getPayeeName());
	    System.out.println("Payee account number is "+payee.getPayeeAccountNumber());
	    System.out.println("Payee nickname is "+payee.getNickName());
	}
	@Test
	void deletePayeeServiceTest()
	
	{
		System.out.println("deleting the payee");
		payeeService.deletePayeeService(4);
	}
		
		
}	

