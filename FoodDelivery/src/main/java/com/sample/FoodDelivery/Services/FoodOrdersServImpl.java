package com.sample.FoodDelivery.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.FoodDelivery.Models.Order;
import com.sample.FoodDelivery.Repos.FoodOrderRepo;

@Service
public class FoodOrdersServImpl implements FoodOrdersServ {
	
	@Autowired
	FoodOrderRepo repo;

	@Override
	public Order Insert(Order order) {
	 return repo.save(order);
	}

	@Override
	public Order Update(Order order) {
		return repo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return repo.findAll();
	}

	@Override
	public Order getById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public void Delete(int id) {
		repo.deleteById(id);
	}

}
