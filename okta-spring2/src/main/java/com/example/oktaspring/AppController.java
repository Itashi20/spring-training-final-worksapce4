package com.example.oktaspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/securenew")
public class AppController {
	
	@GetMapping("/newuser")
	public String loadData() {
		return "New user loaded successfully!";
	}
	


}
