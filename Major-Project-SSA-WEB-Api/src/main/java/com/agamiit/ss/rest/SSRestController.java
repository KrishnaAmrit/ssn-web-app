package com.agamiit.ss.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSRestController {
     
	@GetMapping("/ssn/{ssn}")
	public String getStateName(@PathVariable String ssn) {
		
		if (ssn.startsWith("6")) {
           return "New Jersey";			
		} else if(ssn.startsWith("7")) {
	           return "Arizona";
		}

		else if(ssn.startsWith("5")) {
	           return "Connecticut";
		}
		else if(ssn.startsWith("4")) {
	           return "California";
		}

		else if(ssn.startsWith("3")) {
	           return "Florida";
		}else {
			return "Invalide SSN";
		}	
	
	}
}
