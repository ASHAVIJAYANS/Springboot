package com.sample.addressAPI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.addressAPI.models.Address;
import com.sample.addressAPI.models.AddressResponse;
import com.sample.addressAPI.services.AddressServ;



@RestController
@RequestMapping("/address")
public class AddressesController {
	
	@Autowired
    AddressServ serv;
	
	@GetMapping("/{id}")
	public ResponseEntity<AddressResponse> getAddressDetails(@PathVariable int id)
	{
		Address addr=serv.getAddressDetailsById(id);
		if(addr!=null)
		{
			AddressResponse addres=new AddressResponse();
			addres.setEmpid(addr.getEmpid());
			addres.setAddress1(addr.getAddress1());
			addres.setAddress2(addr.getAddress2());
			addres.setAddress3(addr.getAddress3());
			addres.setCity(addr.getCity());
			addres.setPincode(addr.getPincode());
			
			return ResponseEntity.ok(addres);
			
		}
		return ResponseEntity.notFound().build();
	}


}
