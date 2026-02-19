package com.sample.employee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.employee.models.Employee;
import com.sample.employee.repos.EmployeesRepo;

@Service
public class EmployeeServImpl implements EmployeeServ {
	
	@Autowired
	EmployeesRepo repo;
	
	@Override
	public Employee getEmployeeDetailsById(int id) {
		return repo.findById(id).orElse(null);
	}
	

}
