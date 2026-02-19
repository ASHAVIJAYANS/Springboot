package com.sample.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.sample.employee.models.AddressResponse;
import com.sample.employee.models.Employee;
import com.sample.employee.models.EmployeeResponse;
import com.sample.employee.services.EmployeeServ;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	@Autowired
	EurekaClient eurekaClient;
	
	@Autowired
	RestTemplate rest;
	
	@Autowired
    EmployeeServ serv;
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResponse> getEmpDetails(@PathVariable int id)
	{
		List<InstanceInfo> instances=eurekaClient.getApplication("ADDRESSAPI").getInstances();
		for(var inst:instances)
		{
			System.out.println(inst.getHomePageUrl());
		}
//		String url="http://localhost:8081/address/"+id;
		String url=instances.get(0).getHomePageUrl()+"address/"+id;
		AddressResponse add=rest.getForObject(url, AddressResponse.class);
		System.out.println(add);
		
		
		
		Employee emp=serv.getEmployeeDetailsById(id);
		if(emp!=null)
		{
			EmployeeResponse res=new EmployeeResponse();
			res.setId(emp.getId());
			res.setName(emp.getName());
			res.setAge(emp.getAge());
			res.setDesignation(emp.getDesignation());
			res.setLocation(emp.getLocation());
			res.setAddress(add);
			
			return ResponseEntity.ok(res);
			
		}
		return ResponseEntity.notFound().build();
	}

}
