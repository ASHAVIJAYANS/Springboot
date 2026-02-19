package com.sample.FoodDelivery.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.FoodDelivery.Models.Order;
import com.sample.FoodDelivery.Services.FoodOrdersServ;

@RestController
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
	FoodOrdersServ serv;
	
	@PostMapping
	public ResponseEntity<Order> AddNewOrder(@RequestBody Order order)
	{
		Order result=serv.Insert(order);
		if(result!=null)
		{
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAll()
	{
		return ResponseEntity.ok(serv.getAllOrders());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getById(@PathVariable int id){
		try {
			Order result=serv.getById(id);
			if(result !=null) {
				return ResponseEntity.ok(result);
			}
			return ResponseEntity.notFound().build();
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
			}
		}
	
	@PutMapping("/{id}")
	public ResponseEntity<Order> UpdateOrder(@PathVariable int id,@RequestBody Order order)
	{
		Order result=serv.Update(order);
		if(result!=null)
		{
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> Delete(@PathVariable int id)
	{
		serv.Delete(id);
		return ResponseEntity.ok().build();
	}
	}


