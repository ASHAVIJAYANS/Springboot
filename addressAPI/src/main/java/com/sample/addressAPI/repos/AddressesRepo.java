package com.sample.addressAPI.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.addressAPI.models.Address;

@Repository
public interface AddressesRepo extends JpaRepository<Address, Integer> {
	
	Address findByEmpid(int empid);

}
