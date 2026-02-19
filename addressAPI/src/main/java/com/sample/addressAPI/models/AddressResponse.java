package com.sample.addressAPI.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressResponse {

	private int empid;
	private String address1;
	private String address2;
	private String address3;
	private String city;
	private String pincode;
}
