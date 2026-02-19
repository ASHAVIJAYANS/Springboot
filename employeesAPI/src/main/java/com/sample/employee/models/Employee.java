package com.sample.employee.models;

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
@Table(name="employees")
public class Employee {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="empid")
	private int id;
	private String name;
	private int age;
	private String designation;
	private String location;

}
