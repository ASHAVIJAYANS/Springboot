package com.sample.addressAPI.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="addresses")
public class Address {

		@Id
		@GeneratedValue(strategy =  GenerationType.IDENTITY)
		@Column(name="aid")
		private int id;
		private int empid;
		private String address1;
		private String address2;
		private String address3;
		private String city;
		private String pincode;
		
	}



