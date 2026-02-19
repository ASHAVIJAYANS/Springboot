package com.sample.FoodDelivery.Services;

import java.util.List;

import com.sample.FoodDelivery.Models.Order;

public interface FoodOrdersServ {
	
	Order Insert(Order order);
	Order Update(Order order);
	List<Order> getAllOrders();
	Order getById(int id);
	void Delete(int id);

}
