package com.sample.FoodDelivery.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.FoodDelivery.Models.Order;

@Repository
public interface FoodOrderRepo extends JpaRepository<Order, Integer> {

}
