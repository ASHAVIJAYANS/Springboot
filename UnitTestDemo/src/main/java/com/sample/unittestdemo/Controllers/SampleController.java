package com.sample.unittestdemo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.unittestdemo.models.User;

@RestController
@RequestMapping("/api/test")
public class SampleController {
	
	@GetMapping
	public String Greet()
	{
		return "Hello User!";
	}
	
	@GetMapping("/{id}")
	public String getById(@PathVariable int id)
	{
		return "Id Received:" +id;
	}
	
	
	@PostMapping
	public String addUser(@RequestBody User user)
	{
		return "User Added with Id:"+user.getId();
	}

}
