package com.sample.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("/")
	 public String Sample()
	 {
		 return "Hey User!Welcome...";
	 }
	
	@GetMapping("/test")
	public ResponseEntity<String> TestCode()
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Request Recieved");
	}
    
	@PostMapping("/add")
	public ResponseEntity<String> TestPostReq(@RequestParam String name)
	{
		if(name.length()>3)
		{
			return ResponseEntity.status(HttpStatus.OK).body(name+" is Added to Database");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Input length is less than 3 characters");
		}
	}
}
