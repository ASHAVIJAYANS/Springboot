package com.sample.employee.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeResponse {
	
	private int id;
	private String name;
	private int age;
	private String designation;
	private String location;
	private AddressResponse address;

}
