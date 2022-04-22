package com.sbi.project.layer5;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbi.project.layer2.Applicant;
import com.sbi.project.layer2.Payee;
import com.sbi.project.layer4.PayeeService;

@RestController
@RequestMapping("/payee")
public class PayeeController {

	@Autowired
	PayeeService payeeServ;
	PayeeController(){
		System.out.println("PayeeController()");
	}
	@RequestMapping("/test")
	public String payeeCntrl() {
		return "payee Controller accessed";
	}

	@RequestMapping("/getPayees/{accNo}")
	public List<Payee> getApplicants(@PathVariable("accNo") int accountNumber){
		System.out.println("getApplicant");
		return payeeServ.findAllPayee(accountNumber);
	}
	

	@PostMapping("/addPayee")
	public String addPayee(@RequestBody Payee payee) {
		payeeServ.addPayeeService(payee);
		return "Payee created successfully";
	}
	@RequestMapping("/removePayee/{pId}")
	public void removePayee(@PathVariable ("pId") int pId) {
		payeeServ.deletePayeeService(pId);
	}
	
	@RequestMapping("/getPayee/{pId}")
	public Payee getPayee(@PathVariable("pId") int payeeId)
	{
	Payee payeeObj = payeeServ.findPayee(payeeId);
	
	if (payeeObj != null) {
		return payeeObj;
	}
	else {
		throw new RuntimeException("Payee Not Found");
	}
}
}
