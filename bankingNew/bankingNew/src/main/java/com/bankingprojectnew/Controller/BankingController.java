package com.bankingprojectnew.Controller;
import com.bankingprojectnew.Service.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank")
public class BankingController {
	
	@Autowired
	private BankingService bankingService;
	
	@PostMapping("/deposit")
    public String deposit(@RequestParam int accountId, @RequestParam int amount) {
        return bankingService.deposit(accountId, amount);
    }
	
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam int accountId, @RequestParam int amount) {
        return bankingService.withdraw(accountId, amount);
    }
    
    @GetMapping("/test")
    public String test() {
        return "Controller is working!";
    }

}
