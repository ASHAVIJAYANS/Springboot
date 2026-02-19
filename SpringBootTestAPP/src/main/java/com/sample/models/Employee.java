package com.sample.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {

	  private int id;
	  private String name;
	  private double salary;
	  private String location;
}
