package com.sample.addressAPI.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.addressAPI.models.Address;
import com.sample.addressAPI.repos.AddressesRepo;



@Service
public class AddressServImpl implements AddressServ  {
	
	@Autowired
	AddressesRepo repo;
	
	@Override
	public Address getAddressDetailsById(int id) {
		return repo.findById(id).orElse(null);
	}
 
}