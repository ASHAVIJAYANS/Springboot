package com.sample.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.models.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
     private static List<Employee> emps=new ArrayList<>();
     static {
    	 emps.add(new Employee(1,"John",5000,"Kerala"));
    	 emps.add(new Employee(2,"Asha",115000,"Kerala"));
    	 emps.add(new Employee(3,"Vinod",455000,"Kerala"));
     }
     
     @GetMapping
     public ResponseEntity<List<Employee>> getAll()
     {
    	 return ResponseEntity.ok(emps);
     }
     
     @GetMapping("/{id}")
     public ResponseEntity<Employee> getByEmpId(@PathVariable int id)
     {
    	 if(id>0)
    	 {
    		 for(Employee emp:emps)
    		 {
    			 if(emp.getId()==id)
    			 {
    				 return ResponseEntity.ok(emp);
    			 }
    		 }
    		 return ResponseEntity.notFound().build();
    	 }
    	 else
    	 {
    		 return ResponseEntity.badRequest().build();
    	 }
     }
     
     
     @PostMapping
     public ResponseEntity<Employee> Add(@RequestBody Employee emp)
     
     {
    	 emp.setId(emps.size()+1);
    	 emps.add(emp);
    	 return ResponseEntity.ok(emp);
    	 
     }
     
     @PutMapping("/{id}")
     public ResponseEntity<String> Update(@PathVariable int id,@RequestBody Employee emp)
     {
    	 int count=0;
    	 for(Employee e:emps)
    	 {
    		 if(e.getId()==id)
    		 {
    			 e.setName(emp.getName());
    			 e.setSalary(emp.getSalary());
    			 e.setLocation(emp.getLocation());
    			 count++;
    		 }
    	 }
    	 if(count>0)
    	 {
    		 return ResponseEntity.ok("Updated successfully");
    	}
    	 else
    	 {
    		 return ResponseEntity.badRequest().body("No data found with given id");
    	 }
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity<String> Delete(@PathVariable int id)
     {
    	 int count=0;
    	 for(int i=0;i<emps.size();i++)
    	 {
    		 if(emps.get(i).getId()==id)
    		 {
    			    emps.remove(i);
    			    count++;
    		 }
    	 }
    	 if(count>0)
    	 {
    		 return ResponseEntity.ok("Record Deleted Successfully");
    	 }
    	 else
    	 {
    		 return ResponseEntity.badRequest().body("No data found with given id");
    	 }
     }
}
